package GenericBox;


import java.util.List;

public class Box<T> {

    private T item;


    Box(T item) {
        this.item = item;
    }

    public static <T extends Comparable<T>> int countElements(List<T> list, T item ){

        int count = 0;

        for (int i = 0; i < list.size(); i++) {
            if (item.compareTo(list.get(i))<0){
                count++;
            }
        }
            return count;
    }
}
