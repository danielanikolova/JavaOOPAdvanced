package resources.P04_DetailPrinter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Pesho"));
        employees.add(new Employee("Venci"));
        employees.add(new Manager("Gosho", "document1", "document2" ));

        DetailsPrinter pr = new DetailsPrinter(employees);
        employees.add(new Worker("Ivan", 5));

        pr.printDetails();
    }
}
