package models;


import enums.ReportLevel;
import interfaces.Layout;

public class XmlLayout implements Layout{

    @Override
    public String getFormatMessage(String dateTime, String message, ReportLevel reportLevel) {
       return  "<log>\n" +
                "\t<date>" + dateTime + "</date>\n" +
                "\t<level>" + reportLevel + "</level>\n" +
                "\t<message>" + message+  "</message>\n" +
                "</log>";
    }
}
