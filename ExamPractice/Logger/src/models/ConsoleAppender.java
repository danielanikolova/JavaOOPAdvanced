package models;


import enums.ReportLevel;
import interfaces.Layout;

public class ConsoleAppender extends BaseAppender{


    public ConsoleAppender(Layout layout) {
        super(layout);
    }


    @Override
    public void appendMessage(String dataTime, String message, ReportLevel messageReportLevel) {

        if (messageReportLevel.compareTo(super.getReportLevel())>=0 ){
            System.out.println(super.getLayout().getFormatMessage(dataTime, message, messageReportLevel));
            super.setMessagesAppended(1);

        }
    }

}
