package tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] personInfo = br.readLine().split("\\s+");
        String[] drinkingPersonInfo = br.readLine().split("\\s+");
        String[] intAndDouble = br.readLine().split("\\s+");

        Tuple<String, String> firstT = new Tuple<>((personInfo[0]+ " "+personInfo[1]), personInfo[2]);
        System.out.println(firstT.toString());
        Tuple<String, Integer> secondT = new Tuple<>(drinkingPersonInfo[0], Integer.parseInt(drinkingPersonInfo[1]));
        System.out.println(secondT.toString());
        Tuple<Integer, Double> thirdT = new Tuple<>(Integer.parseInt(intAndDouble[0]), Double.parseDouble(intAndDouble[1]));
        System.out.println(thirdT.toString());
    }
}
