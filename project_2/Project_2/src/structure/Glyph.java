package structure;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 * class glyph 
 * it has some type, can be printed and can be compared to another glyph
 * @author Тарановский
 */
public class Glyph {
    private Type type;
    /**
     * constructor
     */
    public Glyph() {
        type = Type.GLYPH;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
    }
    
    /**
     * override toString
     * @return 
     */
    @Override
    public String toString(){
        return type.toString();
    }
    /**
     * function checks if this glyph equals to another glyph
     * @param newGlyph
     * @return 
     */
    public boolean glyphEquals(Glyph newGlyph) {
        if (!getType().equals(newGlyph.getType())) {
            return false;
        }
        return toString().equals(newGlyph.toString());
    }
}
