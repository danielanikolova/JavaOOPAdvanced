package app;

import app.core.EmergencyManagementSystem;
import app.core.ManagementSystem;
import app.engines.Engine;
import app.interpreters.CommandInterpreter;
import app.interpreters.Interpreter;
import app.io.InputReader;
import app.io.OutputWriter;
import app.io.Reader;
import app.io.Writer;

public class Main {
    public static void main(String[] args) {

        Reader reader = new InputReader();
        Writer writer = new OutputWriter();
        ManagementSystem managementSystem = new EmergencyManagementSystem();
        Interpreter interpreter = new CommandInterpreter(managementSystem);

        Runnable engine = new Engine(reader, writer, interpreter);
        engine.run();
    }

}
