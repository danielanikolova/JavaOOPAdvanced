package BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        List<Species> species = new LinkedList<>();

        while (true){
            if ("End".equalsIgnoreCase(line)){
                break;
            }
            Species current;

            String[]tokens = line.split("\\s+");
            if (tokens.length==3){
                current = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            }else {
                current = new Robot(tokens[0], tokens[1]);
            }
            species.add(current);

            line = br.readLine();
        }

        String endNumbers = br.readLine();

        species.stream().filter(e->e.getId().endsWith(endNumbers))
                .forEach(k-> System.out.println( k.getId()));
    }
}
