package GenericSwapMethodStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int item = Integer.parseInt(br.readLine());
            list.add(item);
        }

        int[] positions = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        List<Integer>result = swapMethod(list, positions[0], positions[1] );

        for (int i = 0; i < result.size(); i++) {
            System.out.println("java.lang.Integer: " + result.get(i));
        }

    }
    public static<T> List<T> swapMethod(List<T>list, int index1, int index2){
        T item1 = list.get(index1);
        T item2 = list.get(index2);
        list.set(index1, item2);
        list.set(index2, item1);

        return list;
    }
}
