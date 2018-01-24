package cresla.engines;

import cresla.core.Manager;
import cresla.io.InputReader;
import cresla.io.OutputWriter;

import java.util.Arrays;
import java.util.List;


public class Engine implements Runnable {

    private InputReader reader;
    private OutputWriter writer;
    private Manager commandManager;

    public Engine(InputReader reader, OutputWriter writer, Manager commandManager) {
        this.reader = reader;
        this.writer = writer;
        this.commandManager = commandManager;
    }

    @Override
    public void run() {
        List<String> input = Arrays.asList( this.reader.readLine().split("\\s+"));

        String commandType = input.get(0);
        List<String> tokens = input.subList(1, input.size());

        whileLoop:
        while (true){
            switch (commandType){
                case "Reactor":
                    this.writer.write(this.commandManager.reactorCommand(tokens));
                    break;
                case "Module":
                    this.writer.write(this.commandManager.moduleCommand(tokens));

                    break;
                case "Report":
                    this.writer.write(this.commandManager.reportCommand(tokens));
                    break;
                case "Exit":
                    this.writer.write(this.commandManager.exitCommand(tokens));
                    break whileLoop;
            }
            input = Arrays.asList( this.reader.readLine().split("\\s+"));
            commandType = input.get(0);
            tokens = input.subList(1, input.size());

        }


    }
}
