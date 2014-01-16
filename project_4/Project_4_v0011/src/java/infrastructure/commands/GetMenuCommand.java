/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infrastructure.commands;

import static constants.DBConstants.DB_MYSQL;
import static constants.ForwardConstants.FORWARD_USER_MENU;
import static constants.RequestParametersConstants.REQUEST_DISH_LIST;
import dao.abstr.DishDAO;
import dao.abstr.sup.DAOFactory;
import data.Dish;
import infrastructure.Command;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 * get menu command
 *
 * @author Alex
 */
public class GetMenuCommand implements Command {

    private static LinkedList<Dish> dishList;

    /**
     * get a dish list
     *
     * @return the dishList
     */
    public static LinkedList<Dish> getDishList() {
        return dishList;
    }

    /**
     * constructor
     */
    public GetMenuCommand() {
        if (dishList == null) {
            DishDAO dishDao = DAOFactory.getFactory(DB_MYSQL).createDishDAO();
            dishList = dishDao.selectAllForMenu();
        }
    }

    /**
     * execute command
     *
     * @param request form servlet
     * @param response to servlet
     * @return the dishList
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute(REQUEST_DISH_LIST.toString(), getDishList());
        return FORWARD_USER_MENU.toString();
    }
}
