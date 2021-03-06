/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.abstr;

import data.User;
import java.util.LinkedList;

/**
 * interface for user dao
 * @author Alex
 */
public interface UserDAO  {

    public LinkedList<User> selectAll();

    public int insert(User user);

    public void update(User user);
    
    public User getUser(String name, String password);
}
