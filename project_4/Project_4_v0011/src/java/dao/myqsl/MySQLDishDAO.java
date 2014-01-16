/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.myqsl;

import static constants.MySQLConstants.MYSQL_DESCRIPTION;
import static constants.MySQLConstants.MYSQL_DISH_ID;
import static constants.MySQLConstants.MYSQL_NAME;
import static constants.MySQLConstants.MYSQL_PRICE;
import dao.abstr.DishDAO;
import data.Dish;
import dao.MyConnection;
import data.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import org.apache.log4j.Logger;

/**
 * mysql dish dao
 *
 * @author Alex
 */
public class MySQLDishDAO implements DishDAO {

    /**
     * select all dishes without content for menu
     *
     * @return list of dish
     */
    @Override
    public LinkedList<Dish> selectAllForMenu() {
        Connection connection = MyConnection.getInstance().getConnection();
        LinkedList<Dish> dishList = new LinkedList();
        try {
            //selecting all dish
            PreparedStatement preparedStatement = connection.prepareStatement("select * from dish");
            ResultSet resultSet = preparedStatement.executeQuery();
            //filling the menu
            while (resultSet.next()) {
                dishList.add(new Dish(
                        Integer.parseInt(resultSet.getString(MYSQL_DISH_ID.toString())),
                        resultSet.getString(MYSQL_NAME.toString()),
                        resultSet.getString(MYSQL_DESCRIPTION.toString()),
                        null,
                        Double.parseDouble(resultSet.getString(MYSQL_PRICE.toString()))
                ));
            }
            
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(MySQLDishDAO.class.getName()).error(ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MySQLDishDAO.class.getName()).error(ex);
            }
        }
        
        return dishList;
    }

    /**
     * select dish by id with content to user (kitchen return)
     *
     * @param id id of dish
     * @param content dish content
     * @return a dish
     */
    @Override
    public Dish selectByID(int id, LinkedList<Component> content) {
        Connection connection = MyConnection.getInstance().getConnection();
        Dish dish = null;
        try {
            //selecting a the dish by id
            PreparedStatement preparedStatement = connection.prepareStatement("select * from dish where dishId = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            //fill
            if (resultSet.next()) {
                dish = new Dish(
                        Integer.parseInt(resultSet.getString(MYSQL_DISH_ID.toString())),
                        resultSet.getString(MYSQL_NAME.toString()),
                        resultSet.getString(MYSQL_DESCRIPTION.toString()),
                        content,
                        Double.parseDouble(resultSet.getString(MYSQL_PRICE.toString()))
                );
            }
            
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(MySQLDishDAO.class.getName()).error(ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MySQLDishDAO.class.getName()).error(ex);
            }
        }
        return dish;
        
    }
    
    @Override
    public LinkedList<Dish> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int insert(Dish dish) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void update(Dish dish) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
