package LinkedListTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        LinkedListTraversal list = new LinkedListTraversalImpl();

        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split("\\s+");
            switch (command[0]){

                case "Add":
                    list.add(Integer.parseInt(command[1]));
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(command[1]));
                    break;
            }
        }

        System.out.println(list.getSize());
        for (Object num:list) {
            System.out.print(num + " ");
        }

    }
}
