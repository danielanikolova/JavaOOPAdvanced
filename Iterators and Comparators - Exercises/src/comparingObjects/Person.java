package comparingObjects;

public class Person implements Comparable<Person>{

    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    @Override
    public int compareTo(Person p) {
        if (this.name.compareTo(p.name) != 0) {
            return this.name.compareTo(p.name);
        } else if (Integer.compare(this.age, p.age) != 0) {
            return Integer.compare(this.age, p.age);
        } else {
            return this.town.compareTo(p.town);
        }

    }
}
