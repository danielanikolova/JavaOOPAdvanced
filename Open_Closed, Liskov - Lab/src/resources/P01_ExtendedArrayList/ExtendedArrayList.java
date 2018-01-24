package resources.P01_ExtendedArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class ExtendedArrayList<T extends Comparable<T>> extends ArrayList<T>{



    public T min(){

        T max = null;
        Iterator<T>iterator = this.iterator();
        while (iterator.hasNext()){
            T element = iterator.next();
            if (max== null || element.compareTo(max)>0){
                max = element;
            }
        }


        return max;
    }

    public T max(){

        T min= null;
        Iterator<T>iterator = this.iterator();
        while (iterator.hasNext()){
            T element = iterator.next();
            if (min== null || element.compareTo(min)>0){
                min = element;
            }
        }

        return min;
    }
}
