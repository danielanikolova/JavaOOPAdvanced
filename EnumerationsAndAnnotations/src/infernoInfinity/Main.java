package infernoInfinity;


import infernoInfinity.classes.CommandInterpreter;
import infernoInfinity.interfaces.CommandExecutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        CommandExecutor commandInterpreter = new CommandInterpreter();

        while (true) {
            String[] input = br.readLine().split(";");
            if (input[0].equals("END")) break;
            commandInterpreter.executeCommand(input);
        }

    }
}
