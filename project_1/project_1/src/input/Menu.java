/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import core.Storage;
import java.util.ResourceBundle;

/**
 * class that represents user console menu
 * @author Тарановский
 */
public class Menu {
    /*
     * variable of property strings
     */
    private static final ResourceBundle bundle = ResourceBundle.getBundle("input.inputProps");
    //storage and input
    private final Storage storage = new Storage();
    private final Input in = new Input();
    
    /**
     * empty constructor
     */
    public Menu() {}

    /**
     * loop of used entered command processing
     */
    public void userInterface() {
        String command;
        do {
            System.out.println(bundle.getString("user.interface1") + 
                    "exit" + bundle.getString("user.interface2") + 
                    "help" + bundle.getString("user.interface3"));
            command = in.safeStringInput();
            process(command);
        } while (!command.equals("exit"));
    }

    /**
     * prints filtered list
     */
    public void printFilteredList() {
        for (int i = 0; i < storage.getFilteredList().size(); i++) {
            System.out.println(storage.getFilteredList().get(i).toString());
        }
    }

    /**
     * function that processes a command
     * @param command command
     */
    public void process(String command) {
        switch (command) {
            case "print initial list": {
                printInitialList();
                break;
            }
            case "set filter": {
                setFilterAll();
                break;
            }
            case "print filtered": {
                storage.filterList();
                printFilteredList();
                break;
            }
            case "clear filter": {
                storage.getFilteredList().clear();
                storage.clearFilter();
                break;
            }
            case "exit": {
                System.out.print(bundle.getString("command.exiting"));
                break;
            }
            case "help": {
                System.out.println(bundle.getString("command.avail"));
                System.out.println("print initial list");
                System.out.println("set filter");
                System.out.println("print filtered");
                System.out.println("clear filter");
                break;
            }
            default: {
                System.out.println(command + bundle.getString("command.invalid"));
                break;
            }
        }
    }

    /**
     * prints initial proposal list
     */
    public void printInitialList() {
        for (int i = 0; i < storage.getInitialList().size(); i++) {
            System.out.println(storage.getInitialList().get(i).toString());
        }
    }

    /**
     * set all the filters by user
     */
    public void setFilterAll() {
        storage.clearFilter();
        System.out.println(bundle.getString("set.filter.name"));
        if (in.safeBooleanInput()) {
            setFilterNameKB();
        }
        System.out.println(bundle.getString("set.filter.type"));
        if (in.safeBooleanInput()) {
            setFilterTypeKB();
        }
        System.out.println(bundle.getString("set.filter.time"));
        if (in.safeBooleanInput()) {
            setFilterTimeLengthKB();
        }
        System.out.println(bundle.getString("set.filter.early.return"));
        if (in.safeBooleanInput()) {
            setFilterEarlyReturnKB();
        }
        System.out.println(bundle.getString("set.filter.release.type"));
        if (in.safeBooleanInput()) {
            setFilterReleaseTypeKB();
        }
        System.out.println(bundle.getString("set.filter.cash"));
        if (in.safeBooleanInput()) {
            setFilterIsCashKB();
        }
        System.out.println(bundle.getString("set.filter.differential"));
        if (in.safeBooleanInput()) {
            setFilterIsdifferentialKB();
        }
    }

    /**
     * set the filter "credit early return" by user
     */
    public void setFilterEarlyReturnKB() {
        System.out.println(bundle.getString("set1.filter.early.return"));
        boolean bool = false;
        bool = in.safeBooleanInput();
        storage.setFilterEarlyReturn(bool);
    }

    /**
     * set the filter "bank name" by user
     */
    public void setFilterNameKB() {
        System.out.print(bundle.getString("set1.filter.name"));
        String string = "";
        string = in.safeStringInput();
        storage.setFilterName(string);
    }

    /**
     * set the filter "credit release type" by user
     */
    public void setFilterReleaseTypeKB() {
        System.out.println(bundle.getString("set1.filter.release.type"));
        boolean bool = false;
        bool = in.safeBooleanInput();
        storage.setFilterReleaseType(bool);
        setFilterLineExpandableKB();
    }

    /**
     * set the filter "line expandable" by user
     */
    public void setFilterLineExpandableKB() {
        System.out.println(bundle.getString("set1.filter.line.expandable"));
        boolean bool = false;
        bool = in.safeBooleanInput();
        storage.setFilterLineExpandable(bool);
    }

    /**
     * set the filter "credit time length" by user
     */
    public void setFilterTimeLengthKB() {
        System.out.println(bundle.getString("set1.filter.time"));
        int filterTimeLength = -1;
        do {
            filterTimeLength = in.safeIntegerInput();
            if (filterTimeLength < 1 | filterTimeLength > 3) {
                System.out.println(bundle.getString("set1.filter.time.error"));
            }
        } while (filterTimeLength < 1 | filterTimeLength > 3);
        storage.setFilterTimeLength(filterTimeLength-1);
    }

    /**
     * set the filter "credit is differential" by user
     */
    public void setFilterIsdifferentialKB() {
        System.out.println(bundle.getString("set1.filter.differential"));
        boolean bool = false;
        bool = in.safeBooleanInput();
        storage.setFilterIsDifferential(bool);
    }

    /**
     * set the filter "credit type" by user
     */
    public void setFilterTypeKB() {
        System.out.println(bundle.getString("set1.filter.type"));
        int filterType = -1;
        do {
            filterType = in.safeIntegerInput();
            if (filterType < 1 | filterType > 3) {
                System.out.println(bundle.getString("set1.filter.type.error"));
            }
        } while (filterType < 1 | filterType > 3);
        storage.setFilterType(filterType-1);
    }

    /**
     * set the filter "credit is given by cash" by user
     */
    public void setFilterIsCashKB() {
        System.out.println(bundle.getString("set1.filter.cash"));
        boolean bool = false;
        bool = in.safeBooleanInput();
        storage.setFilterIsCash(bool);
    }

}
