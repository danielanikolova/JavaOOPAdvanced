package GenericFlatMethod;

import java.util.LinkedList;
import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMin(List<T>list){
        if (list.isEmpty()){
            throw new IllegalArgumentException();
        }

        T t = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (t.compareTo(list.get(i))>0){
                t = list.get(i);
            }
        }

        return t;
    }

    public static <T extends Comparable<T>> T getMax(List<T>list){
        if (list.isEmpty()){
            throw new IllegalArgumentException();
        }
        T t = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (t.compareTo(list.get(i))<0){
                t = list.get(i);
            }
        }

        return t;
    }
    public static <T> List<Integer> getNullIndices(List<T> list){

        if (list.isEmpty()){
            throw  new IllegalArgumentException();
        }

        List<Integer> resultList = new LinkedList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null){
                resultList.add(i);
            }
        }

        return resultList;
    }

    public static  <T> void  flatten(List<? super T> destination, List<List<? extends T>> source){

        for (List<? extends T> list:source) {
                destination.addAll(list);
        }
    }

    public static <T>void addAll(List<? super T> destination, List<? extends T> source){
        destination.addAll(source);
    }
}
