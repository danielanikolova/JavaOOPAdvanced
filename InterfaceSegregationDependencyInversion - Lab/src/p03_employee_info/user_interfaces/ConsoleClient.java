package p03_employee_info.user_interfaces;

public class ConsoleClient {

    private Formatter formatter;
    private InfoProvider infoProvider;

    public ConsoleClient(Formatter formatter, InfoProvider infoProvider) {
        this.formatter = formatter;
        this.infoProvider = infoProvider;
    }

   public String getResult(){
        return this.formatter.format(this.infoProvider.getEmployeesByName());
   }
}
