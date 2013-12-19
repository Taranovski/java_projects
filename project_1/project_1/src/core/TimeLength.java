/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import java.util.ResourceBundle;

/**
 * class that represents credit time length
 * @author Тарановский
 */
public class TimeLength {
    /*
     * variable of property strings
     */
    private static final ResourceBundle bundle = ResourceBundle.getBundle("core.coreProps");
    /*
     * integer value of credit time length
     * @pdOid 3260f9a4-f669-41de-92ae-77f363375a64
     */
    private int timeLength;
    /**
     * state name strings of credit time length
     * @pdOid 354bac2a-a4d5-4efa-9c64-6de6f1124b78
     */
    final public static String[] timeLengthList = {bundle.getString("time.short"),
        bundle.getString("time.middle"), bundle.getString("time.long")};
    
    /**
     * empty constructor
     */
    public TimeLength() {};

    /**
     * get credit time length
     * @return credit time length
     * @pdOid 5d2ed2eb-c55f-4b8a-83c2-6537a322cc26
     */
    public int getTimeLength() {
        return timeLength;
    }

    /**
     * set credit time length
     * @param newTimeLength credit time length
     * @pdOid da1401a7-fef1-4fdb-86fa-0a544c8fc0ea
     */
    public void setTimeLength(int newTimeLength) {
        if (newTimeLength >= 0 & newTimeLength <= 2) {
            timeLength = newTimeLength;
        } else {
            System.out.println(bundle.getString("error.set.time.length"));
            timeLength = 0;
        }
    }
    
}
