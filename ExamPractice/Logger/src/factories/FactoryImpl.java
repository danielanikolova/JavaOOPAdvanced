package factories;


import enums.ReportLevel;
import interfaces.Appender;
import interfaces.Layout;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class FactoryImpl implements Factory {

    public static final String MODELS_PATH = "models.";

    private Appender appender;

    @Override
    @SuppressWarnings("unchecked")
    public Appender createAppender(String[] appenderInfo) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        String appenderName = appenderInfo[0];
        String layoutName = appenderInfo[1];


        Class<Appender> appenderClass = (Class<Appender>) Class.forName(MODELS_PATH + appenderName);
        Class<Layout> layoutClass = (Class<Layout>) Class.forName(MODELS_PATH + layoutName);

        Constructor<Layout> layoutConstructor = layoutClass.getDeclaredConstructor();
        Layout layout = layoutConstructor.newInstance();

        Constructor<Appender> appenderConstructor = appenderClass.getDeclaredConstructor(Layout.class);

        Appender appender = appenderConstructor.newInstance(layout);

        if (appenderInfo.length == 3){
            ReportLevel reportLevel = ReportLevel.valueOf(appenderInfo[2]);
            appender.setReportLevel(reportLevel);
        }

        return appender;
    }
}
