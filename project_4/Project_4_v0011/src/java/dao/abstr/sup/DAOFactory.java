/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.abstr.sup;

import dao.factory.*;
import constants.DBConstants;
import dao.abstr.ComponentDAO;
import dao.abstr.DishDAO;
import dao.abstr.IngredientDAO;
import dao.abstr.OrderDAO;
import dao.abstr.UserDAO;
import org.apache.log4j.Logger;

/**
 * abstract DAO factory
 *
 * @author Alex
 */
public abstract class DAOFactory {

    public abstract ComponentDAO createComponentDAO();
    public abstract DishDAO createDishDAO();
    public abstract IngredientDAO createIngredientDAO();
    public abstract OrderDAO createOrderDAO();
    public abstract UserDAO createUserDAO();

    /**
     * get a concrete factory
     *
     * @param db
     * @return concrete DAO factory
     */
    public static DAOFactory getFactory(DBConstants db) {

        switch (db) {
            case DB_MYSQL: {
                return new MySQLDAOFactory();
            }
            default: {
                return new MySQLDAOFactory();
            }
        }

    }
}
