package Ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();

        Car car = new Ferrari(name);

        System.out.printf("488-Spider/%s/%s/%s", car.useBrakes(),
                car.pushGas(), car.getDriver());

    }
}
