/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Alex
 */
public class Ingredient {

    private int inId;
    private String name;

    /**
     *
     * @param inId
     * @param name
     */
    public Ingredient(int inId, String name) {
        this.inId = inId;
        this.name = name;
    }

    /**
     * get name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the inId
     */
    public int getInId() {
        return inId;
    }

    /**
     * @param inId the inId to set
     */
    public void setInId(int inId) {
        this.inId = inId;
    }

    /**
     * tostring
     * @return string ingredient
     */
    @Override
    public String toString() {
        return name;
        
    }
}
