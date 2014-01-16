/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infrastructure.commands;

import static constants.DBConstants.DB_MYSQL;
import static constants.ForwardConstants.FORWARD_USER_READY;
import static constants.RequestParametersConstants.REQUEST_DISH_LIST;
import static constants.RequestParametersConstants.REQUEST_ORDER_NUMBER;
import static constants.RequestParametersConstants.REQUEST_SUMM;
import dao.abstr.OrderDAO;
import dao.abstr.sup.DAOFactory;
import data.Dish;
import infrastructure.Command;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * user check order command
 * @author Alex
 */
public class UserCheckOrderCommand implements Command {

    /**
     *
     */
    public UserCheckOrderCommand() {
    }

    /**
     * check order
     * sets attributes
     * @param request
     * @param response
     */
    private void checkOrder(HttpServletRequest request, HttpServletResponse response) {
        OrderDAO orderDao = DAOFactory.getFactory(DB_MYSQL).createOrderDAO();
        Integer orderNumber = (Integer) request.getSession().getAttribute(REQUEST_ORDER_NUMBER.toString());
        boolean orderReady = orderDao.checkOrder(orderNumber);
        if (orderReady) {
            double summ = orderDao.getOrderSumm(orderNumber);
            request.setAttribute(REQUEST_SUMM.toString(), summ);
            
            LinkedList<Dish> dishContent = orderDao.getCompleteOrder(orderNumber);
            request.setAttribute(REQUEST_DISH_LIST.toString(), dishContent);
        }
    }

    /**
     * execute command
     * 
     * @param request
     * @param response
     * @return
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        checkOrder(request, response);
        return FORWARD_USER_READY.toString();
    }

}
