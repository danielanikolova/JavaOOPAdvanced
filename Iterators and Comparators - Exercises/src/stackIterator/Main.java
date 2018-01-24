package stackIterator;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        IStackIterator stackIterator = new Stack<>();

        String[] input = br.readLine().split("\\s+");
        while (!"End".equalsIgnoreCase(input[0])){

            switch (input[0]){
                case "Push":
                    String [] strings = new String[input.length-1];
                    for (int i = 1; i <input.length ; i++) {
                        strings[i-1] = input[i].replace(",", "");

                    }
//
                    try {
                        stackIterator.push(strings);
                    }catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Pop":
                    try {
                        stackIterator.pop();
                    }catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;

            }


            input = br.readLine().split("\\s+");
        }


        System.out.print(stackIterator.toString());
        System.out.println(stackIterator.toString());

    }
}
