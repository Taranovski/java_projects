/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import input.*;

/**
 * class that is testing the application
 * @author Alex
 */
public class Test {

    /**
     * main function, has no command line parameters
     * @param args
     */
    public static void main(String args[]) {
        
        Menu menu = new Menu();

        menu.printInitialList();
        menu.userInterface();

    }

}
