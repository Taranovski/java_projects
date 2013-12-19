/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * class has functions to safely input variables
 * @author Alex
 */
public class Input {

    /**
     * variable of property strings
     */
    private static ResourceBundle bundle = ResourceBundle.getBundle("input.inputProps");
    /**
     * variable of class Scanner for console input
     */
    private Scanner input;

    /**
     * constructor
     */
    public Input() {
        input = new Scanner(System.in);

    }

    /**
     * safe boolean input
     * @return boolean value
     */
    public Boolean safeBooleanInput() {
        Boolean bool = false;
        byte c = 0;
        do {
            try {
                bool = input.nextBoolean();
                c++;
            } catch (InputMismatchException e) {
                System.out.println(bundle.getString("error.boolean"));
                input.nextLine();
            }

        } while (c == 0);
        input.nextLine();

        return bool;
    }

    /**
     * safe int input
     * @return int value
     */
    public int safeIntegerInput() {
        int number = 0;
        byte c = 0;

        do {
            try {
                number = input.nextInt();
                c++;
            } catch (InputMismatchException e) {
                System.out.println(bundle.getString("error.integer"));
                input.nextLine();
            }

        } while (c == 0);
        input.nextLine();
        return number;
    }

    /**
     * safe double input
     * @return double value
     */
    public double safeDoubleInput() {
        double number = 0;
        byte c = 0;

        do {
            try {
                number = input.nextDouble();
                c++;
            } catch (InputMismatchException e) {
                System.out.println(bundle.getString("error.double"));
                input.nextLine();
            }

        } while (c == 0);
        input.nextLine();
        return number;
    }

    /**
     * safe string input
     * @return string value
     */
    public String safeStringInput() {
        String string;
        string = input.nextLine();
        return string;
    }
}
