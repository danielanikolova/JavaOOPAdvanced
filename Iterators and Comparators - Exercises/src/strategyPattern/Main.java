package strategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> namePerson = new TreeSet<>(new PersonNameComparator());
        Set<Person> agePerson = new TreeSet<>(new PersonAgeComparator());
        
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split("\\s+");
            Person current = new Person(tokens[0], Integer.parseInt(tokens[1]));
            namePerson.add(current);
            agePerson.add(current);
        }

       namePerson.forEach(System.out::println);
        agePerson.forEach(System.out::println);
    
    }
}
