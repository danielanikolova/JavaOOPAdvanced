package models;

import enums.ReportLevel;
import interfaces.Appender;
import interfaces.Logger;

import java.util.List;


public class LoggerImpl implements Logger{

    private List<Appender> appenders;

    public LoggerImpl(List<Appender> appenders) {
       this.appenders = appenders;
    }

    private void logToAppenders( String dataTime, String message, ReportLevel reportLevel){
        for (Appender ap:appenders) {
            ap.appendMessage( dataTime,message, reportLevel);
        }
    }

    @Override
    public void logWarning(String dataTime, String message, ReportLevel reportLevel) {
        this.logToAppenders(dataTime, message, reportLevel);
    }

    @Override
    public void logError(String dataTime, String message, ReportLevel reportLevel) {
        this.logToAppenders( dataTime, message, reportLevel);
    }

    @Override
    public void logCritical(String dataTime, String message, ReportLevel reportLevel) {
        this.logToAppenders(dataTime, message, reportLevel);
    }

    @Override
    public void logFatal(String dataTime, String message, ReportLevel reportLevel) {
        this.logToAppenders(dataTime, message, reportLevel);
    }

    @Override
    public void logInfo(String dataTime, String message, ReportLevel reportLevel) {
        this.logToAppenders(dataTime, message, reportLevel);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Logger info\n");
        for (Appender ap:this.appenders) {
            sb.append(ap.toString()).append("\n");
        }
        return sb.toString();
    }
}
