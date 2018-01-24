package petClinics;

import petClinics.Entities.Clinic;
import petClinics.Entities.Pet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Pet> pets = new HashMap<>();
        Map<String, Clinic>clinics = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("\\s+");

            switch (input[0]){
                case "Create":
                    if (input[1].equalsIgnoreCase("pet")){
                        Pet current = new Pet(input[2], Integer.parseInt(input[3]), input[4]);
                        pets.put(current.getName(), current);
                    }else if(input[1].equalsIgnoreCase("clinic")){
                       try {
                           Clinic clinic = new Clinic(input[2],Integer.parseInt(input[3]));
                           clinics.put(clinic.getName(), clinic);
                       }catch (IllegalArgumentException ex){
                           System.out.println(ex.getMessage());
                       }
                }
                    break;
                case "Add":
                    String pet = input[1];
                    String clinic = input[2];
                    if (pets.containsKey(pet)){
                        if (clinics.containsKey(clinic)){
                            System.out.println(clinics.get(clinic).addPet(pets.get(pet)));
                        }
                    }
                    break;
                case "Release":
                    String clinicName = input[1];
                    System.out.println(clinics.get(clinicName).release());
                    break;
                case "HasEmptyRooms":
                    System.out.println(clinics.get(input[1]).hasEmptyRooms());
                    break;
                case "Print":
                    if (input.length==2){
                        clinics.get(input[1]).printRooms();
                    }else if (input.length==3){
                        clinics.get(input[1]).printSpecificRoom(Integer.parseInt(input[2]));
                    }
                    break;
            }
        }

    }
}
