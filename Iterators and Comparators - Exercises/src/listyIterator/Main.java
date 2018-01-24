package listyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] createCommand = br.readLine().split("\\s+");
        String[] strings = new String[createCommand.length-1];
        System.arraycopy(createCommand, 1, strings, 0, createCommand.length - 1);
        ListyIterator iterator  = new ListyIterator(strings);

        String[] input = br.readLine().split("\\s+");

        while (true){
            if ("End".equalsIgnoreCase(input[0])){
                break;
            }
            String command = input[0];

            switch (command){
                case "Move":
                    try {
                        System.out.println(iterator.move());
                    }catch (IllegalArgumentException ex){
                        ex.getMessage();
                    }
                    break;
                case "Print":
                    try {
                        iterator.print();
                    }catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "HasNext":
                    try {
                        System.out.println(iterator.hasNext());
                    }catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
            }

            input = br.readLine().split("\\s+");
        }

    }
}
