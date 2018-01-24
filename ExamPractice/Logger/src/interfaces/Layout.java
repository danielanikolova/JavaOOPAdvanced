package interfaces;

import enums.ReportLevel;

public interface Layout {

     String getFormatMessage(String dateTime, String message, ReportLevel reportLevel);
}
