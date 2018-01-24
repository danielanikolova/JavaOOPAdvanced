package p03_employee_info;

import p03_employee_info.bisiness_layer.ConsoleFormatter;
import p03_employee_info.bisiness_layer.EmployeeInfoProvider;
import p03_employee_info.user_interfaces.ConsoleClient;
import p03_employee_info.user_interfaces.Formatter;
import p03_employee_info.user_interfaces.InfoProvider;

public class Main {

    public static void main(String[] args) {
        InfoProvider employeeInfo = new EmployeeInfoProvider();
        Formatter formatter = new ConsoleFormatter();

        ConsoleClient consoleClient = new ConsoleClient(formatter, employeeInfo);

        System.out.println(consoleClient.getResult());
    }
}
