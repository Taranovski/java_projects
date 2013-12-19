/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gem;

/**
 * enum for field names
 * @author Alex
 */
public enum SectionName {
    GEM("gem"), PREC("preciousness"), NAME("name"), ORIGIN("origin"),
    VALUE("value"), VIS("visual_parameters"), COLOR("color"), 
    TRANSP("transparency"), SIDES("sides");
    
    String str;
    /**
     * constructor
     * @param str 
     */
    SectionName(String str) {
        this.str = str;
    }
    /**
     * override toString()
     * @return 
     */
    @Override
    public String toString() {
        return str;
    }
}
