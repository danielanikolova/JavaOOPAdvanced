package hell;

import hell.commands.CommandInterpreter;
import hell.commands.CommandInterpreterImpl;
import hell.engines.Engine;
import hell.io.InputReader;
import hell.io.OutputWriter;
import hell.io.Reader;
import hell.io.Writer;

public class Main {
    public static void main(String[] args) {

        InputReader reader = new Reader();
        OutputWriter writer = new Writer();
        CommandInterpreter interpreter = new CommandInterpreterImpl();
        Runnable engine = new Engine(reader, writer, interpreter);
        engine.run();

    }
}