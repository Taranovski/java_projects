/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package structure;

import java.util.*;

/**
 * class word
 * @author Тарановский
 */
public class Word extends Glyph{
    
    private List<Glyph> word = new LinkedList();
    
    /**
     * constructor
     */
    public Word() {
        super.setType(Type.WORD);
    }
    /**
     * constructor from string
     * @param string 
     */
    public Word(String string) {
        super.setType(Type.WORD);
        for (int i = 0; i < string.length(); i++) {
            word.add(new Symbol(string.charAt(i), Type.COMMON));
        }
    }
    /**
     * add a symbol to the end of the word
     * @param glyph 
     */
    public void add(Symbol glyph) {
        getWord().add(glyph);
    }
    /**
     * remove a given symbol from the word
     * @param glyph 
     */
    public void remove(Symbol glyph) {
        getWord().remove(glyph);
    } 
    /**
     * size
     * @return 
     */
    public int size() {
        return getWord().size();
    }
    
    /**
     * override toString
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder newWord = new StringBuilder();
        for (Glyph i : getWord()) {
            newWord.append(i.toString());
        }
        return newWord.toString();
    }
    
    /**
     * @return the word
     */
    public List<Glyph> getWord() {
        return word;
    }

    /**
     * @param word the word to set
     */
    public void setWord(List<Glyph> word) {
        this.word = word;
    }
}
