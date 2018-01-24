package threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] personInfo = br.readLine().split("\\s+");
        String[] drinkingPersonInfo = br.readLine().split("\\s+");
        String[] bankInfo = br.readLine().split("\\s+");

        Threeuple<String, String, String> firstT =
                new Threeuple<>((personInfo[0]+ " "+personInfo[1]), personInfo[2], personInfo[3]);
        System.out.println(firstT.toString());

        boolean isDrunk = false;
        if (drinkingPersonInfo[2].equalsIgnoreCase("drunk")){
            isDrunk = true;
        }
        Threeuple<String, Integer, Boolean > secondT =
                new Threeuple<>(drinkingPersonInfo[0], Integer.parseInt(drinkingPersonInfo[1]), isDrunk);
        System.out.println(secondT.toString());

        Threeuple<String, Double, String> thirdT = new Threeuple<>(bankInfo[0], Double.parseDouble(bankInfo[1]), bankInfo[2]);
        System.out.println(thirdT.toString());
    }
}
