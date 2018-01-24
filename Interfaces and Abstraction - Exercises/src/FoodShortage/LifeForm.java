package FoodShortage;

public abstract class LifeForm implements Buyer {

    private String name;
    private int age;
    private int foot;


    LifeForm(String name, int age) {
        this.name = name;
        this.age = age;
        this.foot = 0;
    }


    public String getName() {
        return this.name;
    }

    public int getFoot() {
        return this.foot;
    }

    public void setFoot(int foot) {
        this.foot = foot;
    }

    @Override
    public abstract void buyFood();
}
