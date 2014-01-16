/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.myqsl;

import static constants.MySQLConstants.MYSQL_INGREDIENT_ID;
import static constants.MySQLConstants.MYSQL_NAME;
import dao.MyConnection;
import dao.abstr.IngredientDAO;
import data.Ingredient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import org.apache.log4j.Logger;

/**
 * mysql ingredient dao
 *
 * @author Alex
 */
public class MySQLIngredientDAO implements IngredientDAO {

    /**
     * getting ingredient by id
     *
     * @param ingredientId
     * @return
     */
    @Override
    public Ingredient getIngredientById(int ingredientId) {
        Connection connection = MyConnection.getInstance().getConnection();
        Ingredient ingredient = null;
        try {
            //selecting ingredient
            PreparedStatement preparedStatement = connection.prepareStatement("select * from ingredients where inId = ?");
            preparedStatement.setInt(1, ingredientId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                ingredient = new Ingredient(
                        resultSet.getInt(MYSQL_INGREDIENT_ID.toString()),
                        resultSet.getString(MYSQL_NAME.toString())
                );
            }

        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(MySQLIngredientDAO.class.getName()).error(ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MySQLIngredientDAO.class.getName()).error(ex);
            }
        }
        return ingredient;

    }

    @Override
    public LinkedList<Ingredient> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(Ingredient ingredient) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Ingredient ingredient) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
