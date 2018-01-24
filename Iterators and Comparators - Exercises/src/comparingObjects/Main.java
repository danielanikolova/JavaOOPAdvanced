package comparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Person> personList = new ArrayList<>();

        String input = br.readLine();

        while (true){
            if ("end".equalsIgnoreCase(input)){
                break;
            }
            String[] tokens = input.split("\\s+");
            Person person = new Person(tokens[0],Integer.parseInt(tokens[1]), tokens[2]);
            personList.add(person);

            input = br.readLine();
        }

        int N = Integer.parseInt(br.readLine());
        int countEqual = 0;

        if (N >= 0 && N < personList.size()){
            Person person = personList.get(N);
            for (Person p:personList) {
                if (person.compareTo(p) == 0){
                    countEqual++;
                }
            }
        }

        if (countEqual == 0){
            System.out.println("No matches");
        }else {
            System.out.printf("%d %d %d", countEqual, (personList.size()-countEqual), personList.size());
        }

    }
}
