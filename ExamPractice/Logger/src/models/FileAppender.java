package models;



import enums.ReportLevel;
import interfaces.File;
import interfaces.Layout;

public class FileAppender extends BaseAppender{

    private File file;


    public FileAppender(Layout layout) {
        super(layout);
        this.setFile(new LogFile());
    }

    @Override
    public void appendMessage(String dataTime, String message, ReportLevel messageReportLevel) {

        if (messageReportLevel.compareTo(super.getReportLevel())>=0 ){
            String output = this.getLayout().getFormatMessage(dataTime, message, messageReportLevel);
            this.file.write(output);
            super.setMessagesAppended(1);

        }
    }


    public void setFile(File file){
        this.file = file;
    }

    @Override
    public String toString() {
        return super.toString() +", File size: " + this.file.getSize();
    }
}
