/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import structure.Sentence;
import structure.Text;
import java.io.*;
import java.util.*;
import operation.*;

/**
 * class test
 * @author Тарановский
 */
public class Test {

    /**
     *
     * @param args
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Reader fr = new BufferedReader(new FileReader("d:\\testfile.txt"));
        StringBuilder sb = new StringBuilder();
        //reading from file
        while (fr.ready()) {
            sb.append((char) fr.read());
        }
        //deleting least spaces
        String str = sb.toString();
        str = str.replaceAll("\\s+", " ");

        final String DELIM = "[.!?;:,\\(\\)\\{\\} ]";

        StringTokenizer st = new StringTokenizer(str, DELIM, true);

        Analyse an = new Analyse();

        Text text = an.textProcess(st);

        Sentence sentence;
        for (int i = 0; i < text.getText().size(); i++) {
            sentence = text.getText().get(i);
            System.out.println(sentence.toString()
                    + " type of " + sentence.getType()
                    + " and size " + sentence.size());
        }

        System.out.println("");
        List<Sentence> sentenceList = new LinkedList();

        for (int i = 0; i < text.getText().size(); i++) {
            sentenceList.add(text.getText().get(i));
        }
        
        //overriding comparator
        Comparator<Sentence> comp = new Comparator<Sentence>() {
            @Override
            public int compare(Sentence o1, Sentence o2) {
                return o1.size() - o2.size();
            }
        };
        //sorting
        Collections.sort(sentenceList, comp);

        for (int i = 0; i < text.getText().size(); i++) {
            System.out.println(sentenceList.get(i).toString()
                    + " size of " + sentenceList.get(i).size());
        }
    }
}
