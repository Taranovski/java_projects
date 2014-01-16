/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infrastructure.commands;

import static constants.DBConstants.DB_MYSQL;
import static constants.ForwardConstants.FORWARD_USER_EXIT;
import static constants.RequestParametersConstants.REQUEST_ORDER_NUMBER;
import static constants.RequestParametersConstants.REQUEST_SUMM;
import dao.abstr.OrderDAO;
import dao.abstr.sup.DAOFactory;
import infrastructure.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * user pay command
 * @author Alex
 */
public class UserPayCommand implements Command {

    public UserPayCommand() {
    }

    /**
     * execute
     * sets attributes
     * @param request
     * @param response
     * @return
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute(REQUEST_SUMM.toString(), pay(request, response));
        return FORWARD_USER_EXIT.toString();
    }

    /**
     * pay
     *
     * @param request
     * @param response
     * @return
     */
    private double pay(HttpServletRequest request, HttpServletResponse response) {
        OrderDAO orderDao = DAOFactory.getFactory(DB_MYSQL).createOrderDAO();
        Integer orderNumber = (Integer) request.getSession().getAttribute(REQUEST_ORDER_NUMBER.toString());
        double summ = orderDao.getOrderSumm(orderNumber);
        return summ;
    }

}
