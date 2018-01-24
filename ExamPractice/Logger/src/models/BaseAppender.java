package models;


import enums.ReportLevel;
import interfaces.Appender;
import interfaces.Layout;


public abstract class BaseAppender implements Appender{

    private static final ReportLevel REPORT_LEVEL_DEFAULT = ReportLevel.INFO;

    private Layout layout;
    private ReportLevel reportLevel;
    private int messagesAppended;

    public BaseAppender(Layout layout) {
        this.layout = layout;
        this.reportLevel = REPORT_LEVEL_DEFAULT;
        this.messagesAppended = 0;
    }

    public ReportLevel getReportLevel() {
        return this.reportLevel;
    }

    public Layout getLayout() {
        return this.layout;
    }

    public void setMessagesAppended(int messagesAppended) {
        this.messagesAppended += messagesAppended;
    }

    @Override
    public int getMessagesAppended() {
        return this.messagesAppended;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getClass().getSimpleName(),
                this.layout.getClass().getSimpleName(),
                this.reportLevel,
                this.getMessagesAppended());
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }
}
