/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package structure;

/**
 * class symbol
 * @author Тарановский
 */
public class Symbol extends Glyph{
    private char symbol;
    
    /**
     * constructor
     * @param commonCharachter 
     * @param type 
     */
    public Symbol(char commonCharachter, Type type) {
        this.symbol = commonCharachter;
        super.setType(type);
    }

    
    /**
     * override toString
     * @return 
     */
    @Override
    public String toString() {
        return "" + symbol;
    }
    
    

    
}
