package ListUtilities;

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

}
