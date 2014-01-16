/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constants;

/**
 * enum for request parameters get/set
 * @author Alex
 */
public enum RequestParametersConstants {

    REQUEST_DISH_LIST("dishList"), 
    REQUEST_USER_NAME("username"), 
    REQUEST_PASSWORD("password"),
    REQUEST_LOGIN_ERROR("login_error"), 
    REQUEST_USER("user"),
    REQUEST_ORDER_LIST("orderList"),
    REQUEST_RESTRANT_SUMM("restrantSumm"),
    REQUEST_SUBMIT_ORDERS("submitOrders"),
    REQUEST_SUMM("summ"), 
    REQUEST_ORDER_NUMBER("orderNumber"),
    REQUEST_MENU_ERROR("menuError")
    
    ;
        
        private final String constant;

    /**
     * constructor
     *
     * @param string
     */
    RequestParametersConstants(String string) {
        this.constant = string;
    }

    /**
     * tostring
     *
     * @return string constant
     */
    @Override
    public String toString() {
        return constant;
    }

    /**
     * get a constant by string
     *
     * @param string
     * @return
     */
    public static RequestParametersConstants getRequestParametersConstant(String string) {
        for (RequestParametersConstants someConstant : RequestParametersConstants.values()) {
            if (someConstant.toString().equals(string)) {
                return someConstant;
            }
        }
        return null;
    }
}
