package carShopExtended;

public class Main {
    public static void main(String[] args) {


        Sellable seat = new Seat("Leon", "Gray",Integer.parseInt("110"),
                "Spain",Double.parseDouble("11111.1"));
        Rentable audi = new Audi("Leon", "Gray",Integer.parseInt("110"),
                "Spain", Integer.parseInt("3"), Double.parseDouble("99.9"));

        printCarInfo(seat);
        printCarInfo(audi);


    }

    private static void printCarInfo(Car car) {
        System.out.println(String.format(
                "%s is %s color and have %s horse power",
                car.getModel(),
                car.getColor(),
                car.getHorsePower()));
        System.out.println(car.toString());
    }


}
