/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 * client
 *
 * @author Alex
 */
public class User {

    private int id;
    private String name;
    private int role;

    /**
     * constructor
     *
     * @param id
     * @param name
     * @param role
     */
    public User(int id, String name, int role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the role
     */
    public int getRole() {
        return role;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param role the role to set
     */
    public void setRole(int role) {
        this.role = role;
    }

}
