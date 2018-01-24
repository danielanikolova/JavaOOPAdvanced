package GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        List<Double> strings = new ArrayList<>();

        for (int i = 0; i < N; i++) {
//            Box box = new Box(br.readLine());
//            System.out.println("java.lang.Integer: " + box.toString());

            strings.add(Double.parseDouble(br.readLine()));
        }

        Double comparable = Double.parseDouble(br.readLine());

        System.out.println(Box.countElements(strings, comparable));
    }
}
