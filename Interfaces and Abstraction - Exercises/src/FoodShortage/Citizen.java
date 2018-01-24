package FoodShortage;


public class Citizen extends LifeForm implements Buyer {

    private String id;
    private String birthday;

    Citizen(String name, int age, String id, String birthday) {
        super(name, age);
        this.id = id;
        this.birthday = birthday;
    }


    @Override
    public void buyFood() {
        super.setFoot(super.getFoot()+10);
    }
}
