package blackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Class<BlackBoxInt> blackBox = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = blackBox.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        while (true){
            String[] input = br.readLine().split("_");

            if ("END".equalsIgnoreCase(input[0])){
                break;
            }

            String command = input[0];

            Method method = blackBox.getDeclaredMethod(command, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, Integer.parseInt(input[1]));

            Field field = blackBox.getDeclaredField("innerValue");
            field.setAccessible(true);
            System.out.println(field.get(blackBoxInt));

        }


    }
}
