import factories.Factory;
import factories.FactoryImpl;
import interfaces.Runnable;
import io.ConsoleRader;
import io.ConsoleWriter;
import io.Reader;
import io.Writer;
import models.Engine;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {

        Reader reader = new ConsoleRader();
        Writer writer = new ConsoleWriter();
        Factory factory = new FactoryImpl();
        Runnable engine = new Engine(reader, writer, factory);
        engine.run();

    }
}
