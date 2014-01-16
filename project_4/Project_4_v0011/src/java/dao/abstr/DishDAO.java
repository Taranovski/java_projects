/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.abstr;

import data.Component;
import data.Dish;
import java.util.LinkedList;

/**
 * interface for dish dao
 *
 * @author Alex
 */
public interface DishDAO {

    public LinkedList<Dish> selectAll();

    public int insert(Dish dish);

    public void update(Dish dish);

    public LinkedList<Dish> selectAllForMenu();

    public Dish selectByID(int id, LinkedList<Component> content);

}
