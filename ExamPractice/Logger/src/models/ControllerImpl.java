package models;

import enums.ReportLevel;
import interfaces.Controller;
import interfaces.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ControllerImpl implements Controller {

    private Logger logger;

    public ControllerImpl(Logger logger) {
        this.logger = logger;
    }


    @Override
    public void readLog(String message) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String[] messageInfo = message.split("\\|");

        String reportLevelName = messageInfo[0].charAt(0) + messageInfo[0].toLowerCase().substring(1);

        ReportLevel reportLevel = ReportLevel.valueOf(messageInfo[0]);

        Method method = Logger.class
                .getDeclaredMethod("log" + reportLevelName, String.class, String.class, ReportLevel.class);

        method.invoke(this.logger, messageInfo[1], messageInfo[2], reportLevel);


    }

    @Override
    public String getInfo() {
        return this.logger.toString();
    }
}
