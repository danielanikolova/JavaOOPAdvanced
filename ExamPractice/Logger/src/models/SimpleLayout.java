package models;

import enums.ReportLevel;
import interfaces.Layout;


public class SimpleLayout implements Layout{

    @Override
    public String getFormatMessage(String dateTime, String message, ReportLevel reportLevel) {
        return String.format("%s - %s - %s", dateTime, reportLevel.toString(), message);
    }
}
