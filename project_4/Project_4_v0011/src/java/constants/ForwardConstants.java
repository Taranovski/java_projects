/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constants;

/**
 * enum for forward request pages
 * @author Alex
 */
public enum ForwardConstants {

    FORWARD_USER_MENU("/userMenu.jsp"), 
    FORWARD_USER("/user.jsp"),
    FORWARD_ADMIN("/admin.jsp"), 
    FORWARD_INDEX("/index.jsp"),
    FORWARD_ADMIN_TABLE("/adminTable.jsp"),
    FORWARD_USER_READY("/userReady.jsp"),
    FORWARD_USER_EXIT("/userExit.jsp"),
    FORWARD_USER_TABLE("/userTable.jsp")
    ;

    private final String constant;

    /**
     * constructor
     *
     * @param string
     */
    ForwardConstants(String string) {
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
    public static ForwardConstants getForwardConstant(String string) {
        for (ForwardConstants someConstant : ForwardConstants.values()) {
            if (someConstant.toString().equals(string)) {
                return someConstant;
            }
        }
        return null;
    }
}
