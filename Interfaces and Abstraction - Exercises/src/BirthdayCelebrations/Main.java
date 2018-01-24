package BirthdayCelebrations;

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
        List<LifeForm>birthables = new LinkedList<>();

        while (true){
            if ("End".equalsIgnoreCase(line)){
                break;
            }

            String[]tokens = line.split("\\s+");
            String kindOfSpecies = tokens[0];
            if ("Citizen".equalsIgnoreCase(kindOfSpecies)){
                LifeForm current = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                birthables.add(current);
            }else if ("Robot".equalsIgnoreCase(kindOfSpecies)){
                Robot current = new Robot(tokens[1], tokens[2]);
            }else{
                LifeForm pet = new Pet(tokens[1], tokens[2]);
                birthables.add(pet);
            }

            line = br.readLine();
        }

        String year = br.readLine();

        birthables.stream().filter(e->e.getBirthday().endsWith(year))
                .forEach(k-> System.out.println( k.getBirthday()));
    }
}
