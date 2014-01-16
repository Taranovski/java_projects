/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.myqsl;

import static constants.DBConstants.DB_MYSQL;
import static constants.MySQLConstants.MYSQL_AMOUNT;
import static constants.MySQLConstants.MYSQL_INGREDIENT;
import dao.MyConnection;
import dao.abstr.ComponentDAO;
import dao.abstr.IngredientDAO;
import dao.abstr.sup.DAOFactory;
import data.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import org.apache.log4j.Logger;

/**
 * mysql component dao
 *
 * @author Alex
 */
public class MySQLComponentDAO implements ComponentDAO {

    /**
     * make a content of dish, specifien by given id (kitchen)
     *
     * @param dishId
     * @return
     */
    @Override
    public LinkedList<Component> dishContent(int dishId) {
        LinkedList<Component> content = new LinkedList();

        Connection connection = MyConnection.getInstance().getConnection();
        try {
            //selecting all ingredients for dish
            PreparedStatement preparedStatement = connection.prepareStatement("select * from formula where dish = ?");
            preparedStatement.setInt(1, dishId);

            ResultSet resultSet = preparedStatement.executeQuery();

            IngredientDAO ingredientDao = DAOFactory.getFactory(DB_MYSQL).createIngredientDAO();
            //filling the content
            while (resultSet.next()) {
                content.add(new Component(
                        ingredientDao.getIngredientById(resultSet.getInt(MYSQL_INGREDIENT.toString())),
                        resultSet.getDouble(MYSQL_AMOUNT.toString())
                ));
            }

        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(MySQLComponentDAO.class.getName()).error(ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(MySQLComponentDAO.class.getName()).error(ex);
            }
        }

        return content;

    }

    @Override
    public LinkedList<Component> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(Component component) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Component component) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
