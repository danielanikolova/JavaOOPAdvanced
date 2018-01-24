import cresla.core.CommandManager;
import cresla.core.Manager;
import cresla.engines.Engine;
import cresla.io.InputReader;
import cresla.io.OutputWriter;
import cresla.io.Reader;
import cresla.io.Writer;

public class Main {
    public static void main(String[] args) {

            InputReader reader = new Reader();
            OutputWriter writer = new Writer();
            Manager manager = new CommandManager();
            Runnable runnable = new Engine(reader, writer, manager);
            runnable.run();


    }
}
