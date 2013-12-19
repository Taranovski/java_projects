/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package structure;

import java.util.LinkedList;
import java.util.List;

/**
 * class text
 * @author Тарановский
 */
public class Text extends Glyph{
    private List<Sentence> text = new LinkedList();
    
    /**
     * constructor
     */
    public Text() {
        super.setType(Type.TEXT);
    }
    /**
     * text size
     * @return 
     */
    public int size() {
        int number = 0;
        for (Glyph word : getText()) {
            if (word.getClass() == Sentence.class) {
                number++;
            }
        }
        return number;
    }
    
    
    /**
     * @return the text
     */
    public List<Sentence> getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(List<Sentence> text) {
        this.text = text;
    }
    
    /**
     * add a sentence to the end of the text
     * @param glyph sentence to add
     */
    public void add(Sentence glyph) {
        getText().add(glyph);
    }
    
    /**
     * override toString
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder newText = new StringBuilder();
        for (Glyph i : getText()) {
            newText.append(i.toString());
        }
        return newText.toString();
    }
}
