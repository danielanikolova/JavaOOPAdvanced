package interfaces;

import java.lang.reflect.InvocationTargetException;

public interface Controller {

    void readLog(String message) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;


    String getInfo();
}
