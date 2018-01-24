package BirthdayCelebrations;

public abstract class LifeForm implements Birthable,Species{

    private String name;
    private String birthday;

    protected LifeForm(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String getId() {
        return this.name;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }
}
