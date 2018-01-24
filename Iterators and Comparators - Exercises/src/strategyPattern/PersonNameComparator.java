package strategyPattern;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (Integer.compare(o1.getName().length(), o2.getName().length())==0){
            return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
        }
        return Integer.compare(o1.getName().length(), o2.getName().length());
    }
}
