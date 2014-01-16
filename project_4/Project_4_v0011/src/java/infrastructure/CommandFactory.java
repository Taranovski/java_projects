/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infrastructure;

import constants.CommandsConstants;
import infrastructure.commands.UserPayCommand;
import infrastructure.commands.LoginCommand;
import infrastructure.commands.OrderTableCommand;
import infrastructure.commands.GetMenuCommand;
import infrastructure.commands.UserSubmitOrderCommand;
import infrastructure.commands.UserCheckOrderCommand;
import org.apache.log4j.Logger;

/**
 * command factory
 *
 * @author Alex
 */
public class CommandFactory {

    private static CommandFactory commandFactory;

    /**
     * constructor
     */
    private CommandFactory() {
    }

    /**
     * instance of command factory
     *
     * @return
     */
    public static CommandFactory instance() {
        if (commandFactory == null) {
            commandFactory = new CommandFactory();
        }
        return commandFactory;
    }

    /**
     * get command
     *
     * @param command command to get
     * @return command object for execute
     */
    public Command getCommand(String command) {
        CommandsConstants commandType = CommandsConstants.getCommandConstant(command);
        switch (commandType) {
            case COMMAND_LOGIN: {
                return new LoginCommand();
            }
            case COMMAND_GET_MENU: {
                return new GetMenuCommand();
            }
            case COMMAND_SUBMIT_ORDER: {
                return new UserSubmitOrderCommand();
            }
            case COMMAND_USER_CHECK_ORDER: {
                return new UserCheckOrderCommand();
            }
            case COMMAND_ORDER_TABLE: {
                return new OrderTableCommand();
            }
            case COMMAND_USER_PAY: {
                return new UserPayCommand();
            }

            default: {
                Logger.getLogger(CommandFactory.class.getClass()).error(command);
                return null;
            }
        }
    }
}
