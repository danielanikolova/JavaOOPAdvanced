package hell.engines;


import hell.commands.CommandInterpreter;
import hell.io.InputReader;
import hell.io.OutputWriter;

import java.util.Arrays;
import java.util.List;


public class Engine implements Runnable {

    private InputReader reader;
    private OutputWriter writer;
    private CommandInterpreter interpreter;


    public Engine(InputReader reader, OutputWriter writer, CommandInterpreter interpreter) {
        this.reader = reader;
        this.writer = writer;
        this.interpreter = interpreter;
    }

    @Override
    public void run() {

        List<String> tokens = Arrays.asList(this.reader.readLine().split("\\s+"));
        String command = tokens.get(0);

        while (true){
            if ("Quit".equalsIgnoreCase(command)) {
                this.writer.writeLine(this.interpreter.quitCommand());
                break;
            }
            switch (command){
                case "Hero":
                    this.writer.writeLine(this.interpreter.createHero(tokens));
                    break;
                case "Item":
                    this.writer.writeLine(this.interpreter.createItem(tokens));
                    break;
                case "Recipe":
                    this.writer.writeLine(this.interpreter.createRecipe(tokens));
                    break;
                case "Inspect":

                    try {
                        this.writer.writeLine(this.interpreter.inspectCommand(tokens));
                    } catch (NoSuchMethodException | IllegalAccessException e) {
                        e.printStackTrace();
                    }

                    break;

            }
            tokens = Arrays.asList(this.reader.readLine().split("\\s+"));
            command = tokens.get(0);
        }

    }
}
