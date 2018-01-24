package froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] jumps = Arrays.stream( br.readLine()
                .split("[, ]+")).mapToInt(Integer::parseInt).toArray();

        Lake lake = new Lake(jumps);
        String end = br.readLine();

        List<String> result = new ArrayList<>();

        for (Integer jump:lake) {
            result.add(String.valueOf(jump));
        }

        System.out.println(String.join(", ", result));
    }
}
