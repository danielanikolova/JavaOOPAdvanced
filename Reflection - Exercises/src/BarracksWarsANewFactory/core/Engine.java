package BarracksWarsANewFactory.core;


import BarracksWarsANewFactory.core.commands.Inject;
import BarracksWarsANewFactory.interfaces.*;
import BarracksWarsANewFactory.interfaces.Runnable;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;


public class Engine implements Runnable, java.lang.Runnable {

    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;
    private CommandInterpreter commandInterpreter;

    public Engine(Repository repository, UnitFactory unitFactory, CommandInterpreter interpreter) {
        this.repository = repository;
        this.unitFactory = unitFactory;
        this.commandInterpreter = interpreter;
    }


    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();

                if (input.equals("fight")) {
                    break;
                }
                String[] data = input.split("\\s+");
                String commandName = data[0];
                Executable command = (Executable) this.commandInterpreter.interpretCommand(commandName);

                this.data = data;
                this.injectDependencies(command);
                String result = command.execute();

                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException | InstantiationException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void injectDependencies(Executable command) throws IllegalAccessException {

        Field[] commandFields = command.getClass().getSuperclass().getDeclaredFields();

        Field[] engineFields = this.getClass().getDeclaredFields();
        for (Field commandField : commandFields) {
            if (commandField.isAnnotationPresent(Inject.class)){

                for (Field engineField : engineFields) {
                    if (engineField.getType().equals(commandField.getType())&&
                            commandField.getName().equals(engineField.getName())){

                        commandField.setAccessible(true);
                        engineField.setAccessible(true);
                        commandField.set(command, engineField.get(this));

                    }
                }

            }
        }

    }
}
