package MilitaryElite;

import MilitaryElite.entities.*;
import MilitaryElite.interfaces.ISoldier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        Map<Integer, ISoldier> soldiers = new LinkedHashMap<>();

        while (true){
            if ("End".equalsIgnoreCase(line)){
                break;
            }
            String[] tokens = line.split("\\s+");

            String type = tokens[0];

            switch (type){
                case "Private":
                    Private p= new Private(Integer.parseInt(tokens[1]),tokens[2], tokens[3],Double.parseDouble(tokens[4]));
                    soldiers.put(p.getId(),p);
                    break;
                case "Spy":
                    Spy current = new Spy(Integer.parseInt(tokens[1]),tokens[2], tokens[3], tokens[4]);
                    soldiers.put(current.getId(),current);
                    break;
                case "LeutenantGeneral":
                    LeutenantGeneral general = new LeutenantGeneral(Integer.parseInt(tokens[1]),tokens[2], tokens[3],Double.parseDouble(tokens[4]));
                    for (int i = 5; i < tokens.length; i++) {
                        if (soldiers.containsKey(Integer.parseInt(tokens[i]))){
                            general.addPrivate((Private)soldiers.get(Integer.parseInt(tokens[i])));
                        }
                    }
                    soldiers.put(general.getId(), general);
                    break;
                case "Engineer":
                    Engineer engineer = new Engineer(Integer.parseInt(tokens[1]),tokens[2], tokens[3],Double.parseDouble(tokens[4]));

                    if (tokens[5].equalsIgnoreCase("Airforces")||
                            tokens[5].equalsIgnoreCase("Marines")) {

                        Corp corp = new Corp(tokens[5]);
                        engineer.setCorp(corp);
                    }
                            for (int i = 6; i <tokens.length-1 ; i+=2) {
                                Repair repair = new Repair(tokens[i], Integer.parseInt(tokens[i+1]));
                                engineer.addRepair(repair);
                            }
                            soldiers.put(engineer.getId(), engineer);

                    break;
                case "Commando":
                    Commando commando = new Commando(Integer.parseInt(tokens[1]),tokens[2], tokens[3],Double.parseDouble(tokens[4]));

                    if (tokens[5].equalsIgnoreCase("Airforces")||
                            tokens[5].equalsIgnoreCase("Marines")) {
                        Corp corpComando = new Corp(tokens[5]);
                        commando.setCorp(corpComando);
                    }
                        for (int i = 6; i < tokens.length - 1; i += 2) {
                            Mission mission = new Mission(tokens[i], tokens[i + 1]);
                            commando.addMission(mission);
                        }
                        soldiers.put(commando.getId(), commando);


                    break;

            }

            line = br.readLine();
        }
        soldiers.values().forEach(s-> System.out.print(s.toString()));

    }
}
