package p03_employee_info.bisiness_layer;

import p03_employee_info.user_interfaces.Formatter;

public class ConsoleFormatter implements Formatter{

    public String format(Iterable<?> employees) {
        StringBuilder sb = new StringBuilder();
        for (Object employee : employees) {
            sb.append(employee).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
