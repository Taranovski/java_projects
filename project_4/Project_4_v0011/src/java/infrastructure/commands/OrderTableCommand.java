/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infrastructure.commands;

import static constants.DBConstants.DB_MYSQL;
import static constants.ForwardConstants.FORWARD_ADMIN_TABLE;
import static constants.MySQLConstants.MYSQL_ORDER_ID;
import static constants.MySQLConstants.MYSQL_USER_ID;
import static constants.RequestParametersConstants.REQUEST_ORDER_LIST;
import static constants.RequestParametersConstants.REQUEST_RESTRANT_SUMM;
import static constants.RequestParametersConstants.REQUEST_SUBMIT_ORDERS;
import dao.abstr.OrderDAO;
import dao.abstr.sup.DAOFactory;
import data.Order;
import infrastructure.Command;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * check order table
 *
 * @author Alex
 */
public class OrderTableCommand implements Command {

    LinkedList<Order> list;

    /**
     * constructor
     */
    public OrderTableCommand() {
        this.list = new LinkedList();
    }

    /**
     * fill orders for admin table
     */
    private void fillOrders() {
        OrderDAO orderDao = DAOFactory.getFactory(DB_MYSQL).createOrderDAO();

        list = orderDao.selectAllForOrderTable();

    }

    /**
     * execute
     *
     * @param request
     * @param response
     * @return
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        fillOrders();
        confirmOrders(request, response);
        fillOrders();
        request.setAttribute(REQUEST_ORDER_LIST.toString(), list);
        request.setAttribute(REQUEST_RESTRANT_SUMM.toString(), getSumm());

        return FORWARD_ADMIN_TABLE.toString();
    }

    /**
     * confirm orders
     *
     * @param request
     * @param response
     */
    private synchronized void confirmOrders(HttpServletRequest request, HttpServletResponse response) {
        if (!Boolean.parseBoolean(request.getParameter(REQUEST_SUBMIT_ORDERS.toString()))) {
            Logger.getLogger(OrderTableCommand.class.getName())
                    .info(REQUEST_SUBMIT_ORDERS.toString() + request.getParameter(REQUEST_SUBMIT_ORDERS.toString()));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            Logger.getLogger(OrderTableCommand.class.getName())
                    .info(REQUEST_SUBMIT_ORDERS.toString());
            String str = MYSQL_ORDER_ID.toString()
                    + list.get(i).getOrderId()
                    + MYSQL_USER_ID.toString()
                    + list.get(i).getUserId();
            OrderDAO orderDao = DAOFactory.getFactory(DB_MYSQL).createOrderDAO();
            Logger.getLogger(OrderTableCommand.class.getName())
                    .info(str + request.getParameter(str));
            if (Boolean.parseBoolean(request.getParameter(str))) {
                orderDao.confirmOrder(list.get(i).getOrderId());
            }
        }
    }

    private double getSumm() {
        OrderDAO orderDao = DAOFactory.getFactory(DB_MYSQL).createOrderDAO();

        return orderDao.getSumm();
    }
}
