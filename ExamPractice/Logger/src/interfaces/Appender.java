package interfaces;

import enums.ReportLevel;

public interface Appender {

    void appendMessage(String dataTime, String message, ReportLevel reportLevel);

    int getMessagesAppended();

    void setReportLevel(ReportLevel reportLevel);
}
