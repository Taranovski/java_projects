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
public enum UserRoleConstants {
    
    USER_ROLE_CLIENT(1),
    USER_ROLE_ADMIN(2)
    ;
    
    private final int role;
    /**
     * constructor
     * @param role 
     */
    UserRoleConstants(int role) {
        this.role = role;
    }
    /**
     * get a role
     * @return 
     */
    public int getRole() {
        return role;
    }
}
