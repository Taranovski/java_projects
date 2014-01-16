/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.factory;

import dao.abstr.ComponentDAO;
import dao.abstr.DishDAO;
import dao.abstr.IngredientDAO;
import dao.abstr.OrderDAO;
import dao.abstr.UserDAO;
import dao.abstr.sup.DAOFactory;
import dao.myqsl.MySQLComponentDAO;
import dao.myqsl.MySQLDishDAO;
import dao.myqsl.MySQLIngredientDAO;
import dao.myqsl.MySQLOrderDAO;
import dao.myqsl.MySQLUserDAO;

/**
 *
 * @author Alex
 */
public class MySQLDAOFactory extends DAOFactory {

    /**
     *
     * @return
     */
    @Override
    public ComponentDAO createComponentDAO() {
        return new MySQLComponentDAO();
    }

    /**
     *
     * @return
     */
    @Override
    public DishDAO createDishDAO() {
        return new MySQLDishDAO();
    }

    /**
     *
     * @return
     */
    @Override
    public IngredientDAO createIngredientDAO() {
        return new MySQLIngredientDAO();
    }

    /**
     *
     * @return
     */
    @Override
    public OrderDAO createOrderDAO() {
        return new MySQLOrderDAO();
    }

    /**
     *
     * @return
     */
    @Override
    public UserDAO createUserDAO() {
        return new MySQLUserDAO();
    }

}
