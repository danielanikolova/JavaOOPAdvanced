package factories;


import interfaces.Appender;

import java.lang.reflect.InvocationTargetException;

public interface Factory {
     public Appender createAppender(String[] appenderInfo) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
