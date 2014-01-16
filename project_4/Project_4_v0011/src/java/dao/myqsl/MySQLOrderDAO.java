/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.myqsl;

import static constants.DBConstants.DB_MYSQL;
import static constants.MySQLConstants.MYSQL_DISH_ID;
import static constants.MySQLConstants.MYSQL_LAST_INSERT_ID;
import static constants.MySQLConstants.MYSQL_ORDER_ID;
import static constants.MySQLConstants.MYSQL_PRICE;
import static constants.MySQLConstants.MYSQL_READY;
import static constants.MySQLConstants.MYSQL_SUMM;
import static constants.MySQLConstants.MYSQL_SUM_SUMM;
import static constants.MySQLConstants.MYSQL_USER_ID;
import dao.abstr.OrderDAO;
import data.Order;
import dao.MyConnection;
import dao.abstr.ComponentDAO;
import dao.abstr.DishDAO;
import dao.abstr.sup.DAOFactory;
import data.Dish;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import org.apache.log4j.Logger;

/**
 * mysql order dao
 *
 * @author Alex
 */
public class MySQLOrderDAO implements OrderDAO {

    /**
     * select all user-applied orders, that are not submitted
     *
     * @return
     */
    @Override
    public LinkedList<Order> selectAllForOrderTable() {
        LinkedList<Order> list = new LinkedList();
        
        Connection connection = MyConnection.getInstance().getConnection();
        try {
            //selecting all orders

            PreparedStatement preparedStatement = connection.prepareStatement("select * from order_table");
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                //if order is not submitted
                if (resultSet.getInt(MYSQL_READY.toString()) == 0) {
                    list.add(new Order(
                            resultSet.getInt(MYSQL_ORDER_ID.toString()),
                            resultSet.getInt(MYSQL_USER_ID.toString()), null, 0, 0));
                }
            }
            
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(MySQLOrderDAO.class.getName()).error(ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MySQLOrderDAO.class.getName()).error(ex);
            }
        }
        return list;
    }

    /**
     * insert
     *
     * @param order
     * @return
     */
    @Override
    public int insert(Order order) {
        
        int orderId = order.getOrderId();
        int userId = order.getUserId();
        int ready = order.getReady();
        LinkedList<Integer> dishIdList = order.getDishIDList();
        
        Connection connection = MyConnection.getInstance().getConnection();
        
        try {
            
            PreparedStatement preparedStatement
                    = connection.prepareStatement("INSERT INTO order_table (orderId, userId, ready, summ) "
                            + "VALUES (?, ?, 0, 0)");
            preparedStatement.setInt(1, orderId);
            
            preparedStatement.setInt(2, userId);
            preparedStatement.execute();
            
            PreparedStatement preparedStatement2 = connection.prepareCall("select last_insert_id();");
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            if (resultSet2.next()) {
                orderId = resultSet2.getInt(MYSQL_LAST_INSERT_ID.toString());
            }
            
            connection.setAutoCommit(false);
            for (int i = 0; i < dishIdList.size(); i++) {
                PreparedStatement preparedStatement1
                        = connection.prepareStatement("INSERT INTO order_content (orderId, dishId) "
                                + "VALUES (?, ?)");
                preparedStatement1.setInt(1, orderId);
                preparedStatement1.setInt(2, dishIdList.get(i));
                preparedStatement1.execute();
                
            }
            
            connection.commit();
            connection.setAutoCommit(true);
            
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(MySQLOrderDAO.class.getName()).error(ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MySQLOrderDAO.class.getName()).error(ex);
            }
        }
        
        return orderId;
        
    }

    /**
     * select ids of all content of an order
     *
     * @param orderId order id
     * @return a list of dish ids in given order
     */
    @Override
    public LinkedList<Integer> selectAllByOrderId(int orderId) {
        LinkedList<Integer> dishIdList = new LinkedList();
        
        Connection connection = MyConnection.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from order_content where orderID = ?");
            preparedStatement.setInt(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                dishIdList.add(resultSet.getInt(MYSQL_DISH_ID.toString()));
            }
            
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(MySQLOrderDAO.class.getName()).error(ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MySQLOrderDAO.class.getName()).error(ex);
            }
        }
        
        return dishIdList;
        
    }

    /**
     * check if the order is ready
     *
     * @param orderId order id
     * @return if order is ready
     */
    @Override
    public boolean checkOrder(int orderId) {
        Connection connection = MyConnection.getInstance().getConnection();
        int ready = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from order_table where orderId = ?");
            preparedStatement.setInt(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                ready = resultSet.getInt(MYSQL_READY.toString());
            }
            
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(MySQLOrderDAO.class.getName()).error(ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MySQLOrderDAO.class.getName()).error(ex);
            }
        }
        
        return (ready == 1);
        
    }

    /**
     * get a summ for order
     *
     * @param orderId
     * @return
     */
    @Override
    public double getOrderSumm(int orderId) {
        Connection connection = MyConnection.getInstance().getConnection();
        double summ = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from order_table where orderId = ?");
            preparedStatement.setInt(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                summ = resultSet.getDouble(MYSQL_SUMM.toString());
            }
            
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(MySQLOrderDAO.class.getName()).error(ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MySQLOrderDAO.class.getName()).error(ex);
            }
        }
        return summ;
    }

    /**
     * calculate summ for given order
     *
     * @param orderId
     * @return
     */
    @Override
    public double calculateSumm(int orderId) {
        Connection connection = MyConnection.getInstance().getConnection();
        double summ = 0;
        LinkedList<Integer> orderList = selectAllByOrderId(orderId);
        try {
            for (int i = 0; i < orderList.size(); i++) {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from dish where dishId = ?");
                preparedStatement.setInt(1, orderList.get(i));
                ResultSet resultSet = preparedStatement.executeQuery();
                
                if (resultSet.next()) {
                    summ += resultSet.getDouble(MYSQL_PRICE.toString());
                }
            }
            
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(MySQLOrderDAO.class.getName()).error(ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MySQLOrderDAO.class.getName()).error(ex);
            }
        }
        return summ;
    }

    /**
     * get completed order
     *
     * @param orderId
     * @return
     */
    @Override
    public LinkedList<Dish> getCompleteOrder(int orderId) {
        
        LinkedList<Dish> dishList = new LinkedList();
        
        LinkedList<Integer> dishIdList = selectAllByOrderId(orderId);
        ComponentDAO componentDao = DAOFactory.getFactory(DB_MYSQL).createComponentDAO();
        DishDAO dishDao = DAOFactory.getFactory(DB_MYSQL).createDishDAO();
        for (int i = 0; i < dishIdList.size(); i++) {
            dishList.add(dishDao.selectByID(
                    dishIdList.get(i),
                    componentDao.dishContent(dishIdList.get(i))
            ));
        }
        
        return dishList;
        
    }

    /**
     * confirm order
     *
     * @param orderId
     */
    @Override
    public void confirmOrder(int orderId) {
        double summ = calculateSumm(orderId);
        Connection connection = MyConnection.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement
                    = connection.prepareStatement("UPDATE order_table SET ready = 1, summ = ? WHERE orderId = ?");
            preparedStatement.setDouble(1, summ);
            preparedStatement.setInt(2, orderId);
            preparedStatement.execute();
            
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(MySQLOrderDAO.class.getName()).error(ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MySQLOrderDAO.class.getName()).error(ex);
            }
        }
    }

    /**
     * get client order contents
     *
     * @param orderId
     * @return
     */
    @Override
    public LinkedList<Dish> getClientOrderContents(int orderId) {
        LinkedList<Dish> orderContent = fillOrderDishList(selectAllByOrderId(orderId));
        
        return orderContent;
        
    }

    /**
     * fill the order dish list
     *
     * @param order
     * @return
     */
    @Override
    public LinkedList<Dish> fillOrderDishList(LinkedList<Integer> order) {
        DishDAO dishDao = DAOFactory.getFactory(DB_MYSQL).createDishDAO();
        LinkedList<Dish> orderDishList = new LinkedList();
        for (int i = 0; i < order.size(); i++) {
            orderDishList.add(dishDao.selectByID(order.get(i), null));
        }
        
        return orderDishList;
        
    }

    /**
     *
     * @return
     */
    @Override
    public double getSumm() {
        double summ = 0;
        Connection connection = MyConnection.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement
                    = connection.prepareStatement("select sum(summ) from order_table");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                summ = resultSet.getDouble(MYSQL_SUM_SUMM.toString());
            }
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(MySQLOrderDAO.class.getName()).error(ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MySQLOrderDAO.class.getName()).error(ex);
            }
        }
        return summ;
        
    }
    
    @Override
    public LinkedList<Order> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void update(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
