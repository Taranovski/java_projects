/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.LinkedList;

/**
 *
 * @author Alex
 */
public class Order {

    private int orderId;
    private int userId;
    private LinkedList<Integer> dishIdList;
    private int ready;
    private double summ;

    /**
     * constructor
     *
     * @param orderId
     * @param userId
     * @param dishIdList
     * @param ready
     * @param summ
     */
    public Order(int orderId, int userId, LinkedList<Integer> dishIdList, int ready, double summ) {
        this.summ = summ;
        this.orderId = orderId;
        this.userId = userId;
        this.dishIdList = dishIdList;
        this.ready = ready;
    }

    /**
     * @return the orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @return the dishList
     */
    public LinkedList<Integer> getDishIDList() {
        return dishIdList;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @param dishIdList
     */
    public void setDishList(LinkedList<Integer> dishIdList) {
        this.dishIdList = dishIdList;
    }

    /**
     * @return the ready
     */
    public int getReady() {
        return ready;
    }

    /**
     * @param ready the ready to set
     */
    public void setReady(int ready) {
        this.ready = ready;
    }

    /**
     * @return the summ
     */
    public double getSumm() {
        return summ;
    }

    /**
     * @param summ the summ to set
     */
    public void setSumm(double summ) {
        this.summ = summ;
    }

}
