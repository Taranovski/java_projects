/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package constants;

/**
 * enum for database constants
 * @author Alex
 */
public enum DBConstants {
  
    DB_JDBC_LOOKUP("jdbc/restrant"), 
    DB_MYSQL("MySQL")
    ; 
    
    private final String constant;
    /**
     * constructor
     * @param string 
     */
    DBConstants(String string) {
        this.constant = string;
    }
    /**
     * tostring
     * @return string constant
     */
    @Override
    public String toString() {
        return constant;
    }
    /**
     * get a constant by string
     * @param string
     * @return 
     */
    public static DBConstants getDBConstant(String string) {
        for (DBConstants someConstant : DBConstants.values()) {
            if (someConstant.toString().equals(string)) {
                return someConstant;
            }
        }
        return null;
    }
}

