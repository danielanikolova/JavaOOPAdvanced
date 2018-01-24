package customList;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] command = br.readLine().split("\\s+");
        GenericList<String> list = new GenericList<String>();

        while (true){

            if ("End".equalsIgnoreCase(command[0])){
                break;
            }

            switch (command[0]){
                case "Add":
                    list.add(command[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(command[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(command[1]));
                    break;
                case "Swap":
                    list.swap(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(command[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
//                    for (int i = 0; i < list.getList().size(); i++) {
//                        System.out.println(list.getList().get(i));
//                    }
                    System.out.println(list.toString());
                    break;

                case "Sort":
                    list.sort();
                    break;

            }


            command = br.readLine().split("\\s+");
        }
    }
}
