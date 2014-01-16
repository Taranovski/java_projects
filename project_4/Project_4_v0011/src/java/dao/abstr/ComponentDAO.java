/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.abstr;

import data.Component;
import java.util.LinkedList;

/**
 * interface for component dao
 *
 * @author Alex
 */
public interface ComponentDAO {

    public LinkedList<Component> selectAll();
    public int insert(Component component);
    public void update(Component component);

    public LinkedList<Component> dishContent(int dishId);
}
