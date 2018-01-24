package equalityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> personTreeSet = new TreeSet<>();
        Set<Person> personHashSet = new HashSet<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split("\\s+");
            Person current = new Person(tokens[0], Integer.parseInt(tokens[1]));
            personTreeSet.add(current);
            personHashSet.add(current);
        }

        System.out.println(personTreeSet.size());
        System.out.println(personHashSet.size());

    }

}
