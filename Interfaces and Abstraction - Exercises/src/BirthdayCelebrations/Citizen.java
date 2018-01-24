package BirthdayCelebrations;


public class Citizen extends LifeForm {

    private int age;
    private String id;


    Citizen(String name, int age, String id, String birthday) {
        super(name, birthday);
        this.age = age;
        this.id = id;
    }


}
