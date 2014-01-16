/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static constants.DBConstants.DB_JDBC_LOOKUP;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.log4j.Logger;

/**
 * class for connection management
 * @author Alex
 */
public class MyConnection {

    private static MyConnection instance = null;
    private InitialContext initialContext = null;
    private static DataSource dataSource = null;

    /**
     * private constructor as for singleton
     */
    private MyConnection() {
        try {
            // create connection pool
            initialContext = new InitialContext();
            dataSource = (DataSource) initialContext.lookup(DB_JDBC_LOOKUP.toString());
            Logger.getLogger(this.getClass().getName()).info(dataSource.toString());
        } catch (NamingException ex) {
            Logger.getLogger(MyConnection.class.getName()).error(ex);
        }

    }

    /**
     * get instance
     *
     * @return
     */
    public static MyConnection getInstance() {
        if (instance == null) {
            instance = new MyConnection();
        }
        return instance;
    }

    /**
     * get connection method
     *
     * @return
     */
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).error(ex);
            return null;
        }
    }
}
