package interfaces;

import enums.ReportLevel;

public interface Logger {

    void logWarning(String dataTime, String message, ReportLevel reportLevel);
    void logError(String dataTime, String message, ReportLevel reportLevel);
    void logCritical(String dataTime, String message, ReportLevel reportLevel);
    void logFatal(String dataTime, String message, ReportLevel reportLevel);
    void logInfo(String dataTime, String message, ReportLevel reportLevel);



}
