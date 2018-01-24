package FoodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String,LifeForm> people = new HashMap<>();

        for (int i = 0; i < N; i++) {

            String[] tokens = br.readLine().split("\\s+");
            LifeForm current;
            if (tokens.length==4){
                current = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
            }else {
                current = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            }
            people.put(tokens[0],current);

        }
        String line = br.readLine();

        while (!"End".equalsIgnoreCase(line)){

            if (people.containsKey(line)){
                people.get(line).buyFood();
            }

            line = br.readLine();
        }

        int result =0;
        for (LifeForm current:people.values()) {
            result+=current.getFoot();
        }

        System.out.println(result);

    }
}
