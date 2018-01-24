package models;


import factories.Factory;
import interfaces.Appender;
import interfaces.Controller;
import interfaces.Runnable;
import io.Reader;
import io.Writer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Engine implements Runnable{

    private Reader reader;
    private Writer writer;
    private Factory factory;
    private Controller controller;

    public Engine(Reader reader, Writer writer, Factory factory) {
        this.reader = reader;
        this.writer = writer;
        this.factory = factory;
    }

    @Override
    public void run() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        int appendersNumber = Integer.parseInt(reader.readLine());
        List<Appender>appenders = new ArrayList<>();
        for (int i = 0; i < appendersNumber; i++) {
            String [] appenderInfo = reader.readLine().split("\\s+");
            Appender current = this.factory.createAppender(appenderInfo);
            appenders.add(current);
        }

        this.controller = new ControllerImpl(new LoggerImpl(appenders));

        while (true){
            String message = reader.readLine();
            if (message.equalsIgnoreCase("End")){
                break;
            }

            controller.readLog(message);
        }

        System.out.println(controller.getInfo());

    }

}
