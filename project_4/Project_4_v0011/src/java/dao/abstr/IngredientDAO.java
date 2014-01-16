/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.abstr;

import data.Ingredient;
import java.util.LinkedList;

/**
 * interface for ingredient dao
 *
 * @author Alex
 */
public interface IngredientDAO {

    public LinkedList<Ingredient> selectAll();

    public int insert(Ingredient ingredient);

    public void update(Ingredient ingredient);

    public Ingredient getIngredientById(int ingredientId);
}
