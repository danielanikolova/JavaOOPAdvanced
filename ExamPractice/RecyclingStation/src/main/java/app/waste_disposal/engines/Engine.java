package app.waste_disposal.engines;

import app.waste_disposal.io.InputReader;
import app.waste_disposal.io.OutputWriter;

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


            if ("TimeToRecycle".equalsIgnoreCase(command)) {
                break;
            }
            switch (command){
                case "ProcessGarbage":
                    List<String> params =Arrays.asList(tokens.get(1).split("\\|"));
                    this.writer.writeLine(this.interpreter.processGarbage(params));
                    break;
                case "Status":
                    this.writer.writeLine(this.interpreter.processStatus());
                    break;

            }
            tokens = Arrays.asList(this.reader.readLine().split("\\s+"));
            command = tokens.get(0);
        }

    }
}
