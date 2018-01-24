package BarracksWarsANewFactory.interpreters;

import BarracksWarsANewFactory.interfaces.CommandInterpreter;
import BarracksWarsANewFactory.interfaces.Executable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class CommandInterpreterImpl implements CommandInterpreter {
   private static final String COMMANDS_PACKAGE_NAME =
           "BarracksWarsANewFactory.core.commands.";


    @Override
    public Executable interpretCommand(String commandName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
       String commandNameFinal = String.valueOf(commandName.charAt(0)).toUpperCase() +
               commandName.substring(1);
        Class<?> commandClass = null;
       try {
           commandClass = Class.forName(COMMANDS_PACKAGE_NAME + commandNameFinal + "Command");

       }catch (ClassNotFoundException ex){
           throw new RuntimeException("Invalid command");
       }

       Constructor<?> constructor = commandClass.getDeclaredConstructor();
        Executable command = (Executable) constructor.newInstance();

        return command;
    }
}
