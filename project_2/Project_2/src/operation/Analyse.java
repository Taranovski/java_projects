/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package operation;

import structure.*;

import java.io.*;
import java.util.StringTokenizer;

/**
 * class has functions for text analyse
 * @author Тарановский
 */
public class Analyse {
    
    public final String SPACE = "\\s";
    public final String DELIM = "[;:,\\(\\)\\{\\}=]";
    public final String ENDSENT = "[.!?]";
        
    /**
     * analyse a glyph
     * @param str string to analyse
     * @return glyph
     */
    public Glyph analyse(String str) {
        int size = str.length();
        if (size > 1) {
            return new Word(str);
        } else {
            if (str.matches(SPACE)) {
                return new Symbol(str.charAt(0), Type.SPACE);
            } else if (str.matches(DELIM)) {
                return new Symbol(str.charAt(0), Type.DIVISION);
            } else if (str.matches(ENDSENT)) {
                return new Symbol(str.charAt(0), Type.ENDSENTENCE);
            } else {
                return new Word(str);
            }
        }
    }
    
    /**
     * split text into glyph
     *
     * @param st string tokenizer
     * @return text splitted text
     * @throws IOException
     */
    public Text textProcess(StringTokenizer st) throws IOException {

        Text text = new Text();
        Sentence sentence = new Sentence();
        Word word = new Word();
        text.add(sentence);
        sentence.add(word);
        Sentence currentSentence = sentence;
        boolean sentenceEnd = false;
        //processing
        while (st.hasMoreTokens()) {
            Glyph next = analyse(st.nextToken());
            switch (next.getType()) {
                case WORD: {
                    if (sentenceEnd) {
                            currentSentence = new Sentence();
                            text.add(currentSentence);
                            sentenceEnd = false;
                        }
                    currentSentence.add(next);
                    break;
                }
                case DIVISION: {
                    currentSentence.add(next);
                    break;
                }
                case SPACE: {
                    currentSentence.add(next);
                    break;
                }
                case ENDSENTENCE: {
                    currentSentence.add(next);
                    sentenceEnd = true;
                    break;
                }
                default: {
                    System.out.println("error /" + next.toString() + "/");
                    break;
                }
            }
        }
        return text;
    }
}
