/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package constants;

/**
 * enum of command constants
 * @author Alex
 */
public enum CommandsConstants {
    COMMAND("command"), 
    COMMAND_LOGIN("login"), 
    COMMAND_GET_MENU("getMenu"), 
    COMMAND_SUBMIT_ORDER("submitOrder"), 
    COMMAND_USER_CHECK_ORDER("userCheckOrder"),
    COMMAND_ORDER_TABLE("orderTable"), 
    COMMAND_USER_PAY("userPay")
    ;
    private final String constant;
    /**
     * constructor
     * @param string 
     */
    CommandsConstants(String string) {
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
    public static CommandsConstants getCommandConstant(String string) {
        for (CommandsConstants someConstant : CommandsConstants.values()) {
            if (someConstant.toString().equals(string)) {
                return someConstant;
            }
        }
        return null;
    }
}
