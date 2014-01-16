/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package constants;

/**
 * enum for mysql tables collumns
 * @author Alex
 */
public enum MySQLConstants {
    
    //DB table collumns
    MYSQL_AMOUNT("amount"), 
    MYSQL_DISH_ID("dishId"), 
    MYSQL_NAME("name"), 
    MYSQL_DESCRIPTION("description"),
    MYSQL_PRICE("price"), 
    MYSQL_INGREDIENT("ingredient"),
    MYSQL_INGREDIENT_ID("inId"), 
    MYSQL_SUMM("summ"), 
    MYSQL_READY("ready"),
    MYSQL_ORDER_ID("orderId"), 
    MYSQL_USER_ID("userId"), 
    MYSQL_ROLE("role"),
    MYSQL_SUM_SUMM("sum(summ)"),
    MYSQL_LAST_INSERT_ID("last_insert_id()"),
    MYSQL_PASS("pass")
    
    ; 
    
    private final String constant;
    /**
     * constructor
     * @param string 
     */
    MySQLConstants(String string) {
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
    public static MySQLConstants getMySQLConstant(String string) {
        for (MySQLConstants someConstant : MySQLConstants.values()) {
            if (someConstant.toString().equals(string)) {
                return someConstant;
            }
        }
        return null;
    }
}
