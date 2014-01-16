/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.abstr;

import data.Dish;
import data.Order;
import java.util.LinkedList;

/**
 * interface for order dao
 *
 * @author Alex
 */
public interface OrderDAO {

    public LinkedList<Order> selectAll();

    public int insert(Order order);

    public void update(Order order);

    public LinkedList<Integer> selectAllByOrderId(int orderId);

    public LinkedList<Order> selectAllForOrderTable();

    public boolean checkOrder(int orderId);

    public double getOrderSumm(int orderId);

    public LinkedList<Dish> getCompleteOrder(int orderId);

    public void confirmOrder(int orderId);

    public double calculateSumm(int orderId);
    
    public LinkedList<Dish> getClientOrderContents(int orderId);
    
    public LinkedList<Dish> fillOrderDishList(LinkedList<Integer> order);
    
    public double getSumm();
}
