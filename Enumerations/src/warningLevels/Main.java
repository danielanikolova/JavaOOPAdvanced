package warningLevels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String level = br.readLine();
        Importance importance = Importance.valueOf(level);
        Logger logger = new Logger();
        String[] input = br.readLine().split(": ");

        while (true){
            if (input[0].equalsIgnoreCase("END")){
                break;
            }

            Message message = new Message(input[1], input[0]);
            logger.receiveMessage(message, importance);


            input = br.readLine().split(": ");
        }

        for (Message mes :logger.getMessages()) {
            System.out.println(mes);
        }
    }
}
