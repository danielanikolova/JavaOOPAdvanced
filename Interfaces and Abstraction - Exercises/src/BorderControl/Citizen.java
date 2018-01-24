package BorderControl;


public class Citizen implements Species{
    private String name;
    private int age;
    private String id;


    Citizen(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

}
