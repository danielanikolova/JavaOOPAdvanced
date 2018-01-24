package harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Class richSoilLand = RichSoilLand.class;
        while (true){
            String command = br.readLine();

            if ("HARVEST".equalsIgnoreCase(command)){
                break;
            }
            Field[] fields = richSoilLand.getDeclaredFields();
            switch (command){
                case "private":
                    Arrays.stream(fields)
                            .filter(f-> Modifier.isPrivate(f.getModifiers()))
                            .forEach(f-> System.out.println("private "  + f.getType().getSimpleName() + " " + f.getName()));
                    break;
                case "protected":
                    Arrays.stream(fields)
                            .filter(f->Modifier.isProtected(f.getModifiers()))
                            .forEach(f-> System.out.println("protected " + f.getType().getSimpleName() + " " + f.getName()));
                    break;
                case "public":
                    Arrays.stream(fields)
                            .filter(f->Modifier.isPublic(f.getModifiers()))
                            .forEach(f-> System.out.println("public " + f.getType().getSimpleName() + " " + f.getName()));
                    break;
                case "all":
                    Arrays.stream(fields)
                            .forEach(f-> System.out.println(getStringModifier(f) + " " + f.getType().getSimpleName() + " " + f.getName()));
                    break;

            }
        }

    }

    private static String getStringModifier(Field f) {
        
        int modifier = f.getModifiers();
        
        switch (modifier){
            case 1:
                return "public";

            case 2:
                return "private";

            case 4:
                return "protected";

                default:
                    return  "";
        }
    }
}
