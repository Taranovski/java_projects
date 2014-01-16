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
public class Dish {
    
    private int dishId;
    private String name;
    private String description;
    private LinkedList<Component> content;
    private double price;

    /**
     * constructor
     * @param dishId
     * @param name
     * @param description
     * @param content
     * @param price
     */
    public Dish(int dishId, String name, String description, LinkedList<Component> content, double price) {
        this.dishId = dishId;
        this.name = name;
        this.description = description;
        this.content = content;
        this.price = price;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the content
     */
    public LinkedList<Component> getContent() {
        return content;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return the dishId
     */
    public int getDishId() {
        return dishId;
    }

    /**
     * @param dishId the dishId to set
     */
    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param content the content to set
     */
    public void setContent(LinkedList<Component> content) {
        this.content = content;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
