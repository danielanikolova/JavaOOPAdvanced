package app.engines;

import app.commands.Executable;
import app.interpreters.Interpreter;
import app.io.Reader;
import app.io.Writer;

import java.io.IOException;
import java.lang.Runnable;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable{

    private Reader reader;
    private Writer writer;
    private Interpreter interpreter;

    public Engine(Reader reader, Writer writer, Interpreter interpreter) {
        this.reader = reader;
        this.writer = writer;
        this.interpreter = interpreter;
    }

    @Override
    public void run() {
        try {
            String line = this.reader.read();
            while (true) {
                if ("EmergencyBreak".equals(line)) break;

                Executable executable = this.interpreter.interpretCommand(line);
                String result = executable.execute();

                this.writer.write(result);

                line = this.reader.read();
            }
        } catch (IOException | InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
