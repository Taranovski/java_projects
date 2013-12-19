/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package structure;

import java.util.*;

/**
 * sentence
 * it has a list of glyphs inside
 * @author Тарановский
 */
public class Sentence extends Glyph{
    
    private List<Glyph> sentence = new LinkedList();
    /**
     * constructor
     */
    public Sentence() {
        super.setType(Type.SENTENCE);
    }
    /**
     * setnence size
     * @return size of sentence
     */
    public int size() {
        int number = 0;
        for (Glyph word : sentence) {
            if (word.getClass() == Word.class) {
                number++;
            }
        }
        return number;
    }
    
    /**
     * add a glyph to end of this sentence
     * @param glyph glyph to add
     */
    public void add(Glyph glyph) {
        getSentence().add(glyph);
    }

    /**
     * @return the sentence
     */
    public List<Glyph> getSentence() {
        return sentence;
    }

    /**
     * @param sentence the sentence to set
     */
    public void setSentence(List<Glyph> sentence) {
        this.sentence = sentence;
    }
    
    /**
     * override toString
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder newSentence = new StringBuilder();
        for (Glyph i : getSentence()) {
            newSentence.append(i.toString());
        }
        return newSentence.toString();
    }
}
