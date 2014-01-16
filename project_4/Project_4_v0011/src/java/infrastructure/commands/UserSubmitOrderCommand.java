/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infrastructure.commands;

import static constants.DBConstants.DB_MYSQL;
import static constants.ForwardConstants.FORWARD_USER_MENU;
import static constants.ForwardConstants.FORWARD_USER_TABLE;
import static constants.OrderSubmitErrorConstants.ORDER_ERROR_EMPTY;
import static constants.OrderSubmitErrorConstants.ORDER_ERROR_NOT_NUMBER;
import static constants.RequestParametersConstants.REQUEST_DISH_LIST;
import static constants.RequestParametersConstants.REQUEST_MENU_ERROR;
import static constants.RequestParametersConstants.REQUEST_ORDER_NUMBER;
import static constants.RequestParametersConstants.REQUEST_USER;
import dao.abstr.DishDAO;
import dao.abstr.OrderDAO;
import dao.abstr.sup.DAOFactory;
import data.Dish;
import data.Order;
import data.User;
import infrastructure.Command;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 * user submit order command
 * @author Тарановский
 */
public class UserSubmitOrderCommand implements Command {

    private int menuError = 0;
    private static LinkedList<Dish> menu;
    private LinkedList<Integer> order;
    private LinkedList<Dish> orderDishList;

    /**
     * constructor
     */
    public UserSubmitOrderCommand() {
        this.orderDishList = new LinkedList();
        this.order = new LinkedList();
        menuError = 0;
        if (menu == null) {
            DishDAO dishDao = DAOFactory.getFactory(DB_MYSQL).createDishDAO();
            menu = dishDao.selectAllForMenu();
        }

    }

    /**
     * fill order list
     *
     * @param request
     * @param response
     */
    private void fillOrder(HttpServletRequest request, HttpServletResponse response) {

        int itemsNumber = 0;
        int emptyCheck = 0;

        for (Dish dish : menu) {
            String parameter = dish.getDishId() + dish.getName();
            String formRequest = request.getParameter(parameter);

            try {
                itemsNumber = Integer.parseInt(formRequest);
                if (itemsNumber > 0) {
                    for (int i = 0; i < itemsNumber; i++) {
                        order.add(dish.getDishId());
                    }
                } else {
                    emptyCheck++;
                }
            } catch (NumberFormatException numberFormatException) {
                Logger.getLogger(UserSubmitOrderCommand.class.getName())
                        .error(numberFormatException);
                menuError = ORDER_ERROR_NOT_NUMBER.getError();
                break;
            }
            if (emptyCheck == menu.size()) {
                menuError = ORDER_ERROR_EMPTY.getError();
            }
        }
    }

    /**
     * execute command
     * sets attributes
     * @param request
     * @param response
     * @return
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        fillOrder(request, response);

        if (menuError > 0) {
            request.setAttribute(REQUEST_MENU_ERROR.toString(), menuError);
            request.setAttribute(REQUEST_DISH_LIST.toString(), menu);
            return FORWARD_USER_MENU.toString();
        }
        
        submitOrder(request, response);
        return FORWARD_USER_TABLE.toString();

    }

    /**
     * submit order
     * sets attributes
     * @param request
     * @param response
     */
    private void submitOrder(HttpServletRequest request, HttpServletResponse response) {
        User authUser = (User) request.getSession().getAttribute(REQUEST_USER.toString());
        OrderDAO orderDao = (OrderDAO) DAOFactory.getFactory(DB_MYSQL).createOrderDAO();
        Order myOrder = new Order(0, authUser.getId(), order, 0, 0);
        Integer orderNumber = orderDao.insert(myOrder);
        orderDishList = orderDao.fillOrderDishList(order);
        request.getSession().setAttribute(REQUEST_ORDER_NUMBER.toString(), orderNumber);
        request.setAttribute(REQUEST_DISH_LIST.toString(), orderDishList);

    }

}
