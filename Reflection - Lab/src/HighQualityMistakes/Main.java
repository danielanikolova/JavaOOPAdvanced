package HighQualityMistakes;

import javafx.scene.effect.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class reflectionClass = Reflection.class;

        Arrays.stream(reflectionClass.getDeclaredFields())
                .filter(f->!Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f->System.out.println(f.getName() + " must be private!"));

        Arrays.stream(reflectionClass.getDeclaredMethods())
                .filter(m->m.getName().startsWith("get"))
                .filter(m->!Modifier.isPublic(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m-> System.out.println(m.getName()+" have to be public!"));

        Arrays.stream(reflectionClass.getDeclaredMethods())
                .filter(m->m.getName().startsWith("set"))
                .filter(m->!Modifier.isPrivate(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m-> System.out.println(m.getName() +" have to be private!" ));

    }
}
