/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import java.util.ResourceBundle;

/**
 * class that represents credit type, can be consumer, car credit or mortgage
 * @author Тарановский
 */
public class Type {
    /*
     * variable of property strings
     */
    private static ResourceBundle bundle = ResourceBundle.getBundle("core.coreProps");
    /**
     * state name strings
     * @pdOid 822e75f4-27db-4ddd-a6e9-5293eb88e2d3
     */
    public static final String[] typeList = {bundle.getString("type.consumer"), 
        bundle.getString("type.car"), bundle.getString("type.mortgage")};
    /*
     * integer value of credit type
     * @pdOid f436017a-98e6-46c7-b7a9-40faef82c93d
     */
    private int type;

    /**
     * empty constructor
     */
    public Type() {}
    
    /**
     * set credit type
     * @param newType credit type
     * @pdOid def0c504-b912-4649-800d-78ee372e66db
     */
    public void setType(int newType) {
        if (newType >= 0 & newType < typeList.length) {
            type = newType;
        } else {
            System.out.println(bundle.getString("error.set.type"));
            type = 0;
        }
    }

    /**
     * get credit type
     * @return credit type
     * @pdOid 82f763c7-afb5-4e68-86cc-df0bb387745d
     */
    public int getType() {
        return type;
    }
    
}
