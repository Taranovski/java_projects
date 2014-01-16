/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constants;

/**
 *
 * @author Alex
 */
public enum OrderSubmitErrorConstants {

    ORDER_ERROR_NOT_NUMBER(1),
    ORDER_ERROR_EMPTY(2);

    private final int error;

    /**
     * constructor
     *
     * @param error
     */
    OrderSubmitErrorConstants(int error) {
        this.error = error;
    }

    /**
     * get a error
     *
     * @return
     */
    public int getError() {
        return error;
    }
}
