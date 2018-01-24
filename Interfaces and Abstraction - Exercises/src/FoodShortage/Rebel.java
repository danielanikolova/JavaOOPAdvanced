package FoodShortage;

public class Rebel extends LifeForm{

    private String group;

    public Rebel(String name, int age, String group) {
        super(name, age);
        this.group = group;
    }

    @Override
    public void buyFood() {
        super.setFoot(super.getFoot()+5);
    }
}
