/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.myqsl;

import static constants.MySQLConstants.MYSQL_PASS;
import static constants.MySQLConstants.MYSQL_ROLE;
import static constants.MySQLConstants.MYSQL_USER_ID;
import dao.abstr.UserDAO;
import data.User;
import dao.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import org.apache.log4j.Logger;

/**
 *
 * @author Alex
 */
public class MySQLUserDAO implements UserDAO {

    /**
     * get a user from db
     *
     * @param user
     * @param pass
     * @return
     */
    @Override
    public User getUser(String user, String pass) {
        Connection connection = MyConnection.getInstance().getConnection();
        User userClient = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user where user.name = ?");
            preparedStatement.setString(1, user);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                if (resultSet.getInt(MYSQL_PASS.toString()) == pass.hashCode()) {

                    userClient = new User(resultSet.getInt(
                            MYSQL_USER_ID.toString()),
                            user,
                            resultSet.getInt(MYSQL_ROLE.toString()));
                }
            }

        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(MySQLUserDAO.class.getName()).error(ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(MySQLUserDAO.class.getName()).error(ex);
            }
        }
        return userClient;

    }

    @Override
    public LinkedList<User> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
