package NullFinder;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1,2,3,null,5,null,6,7);

        List<String>strings = new ArrayList<>();
        Collections.addAll(strings, null, "sss", "fffff", null);

        List<Integer>StringResult = ListUtils.getNullIndices(integers);
        System.out.println();

    }
}
