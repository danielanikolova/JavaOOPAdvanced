package createAnnotation;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Class cl = Main.class;
        Subject subject = (Subject) cl.getAnnotation(Subject.class);
        System.out.println(Arrays.toString(subject.categories()));
    }
}
