package customList;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericList<T extends Comparable<T>>{

    private List<T> list;

    public GenericList() {
        this.list = new ArrayList<T>();
    }


    public void add(T element){
        this.list.add(element);
   }
    public T remove(int index){
         return this.list.remove(index);
    }

   public boolean contains(T element){
        return this.list.contains(element);
   }

   public void swap(int index, int index2) {

       T first = this.list.get(index);
       T second = this.list.get(index2);
       this.list.set(index, second);
       this.list.set(index2, first);
   }
   public int countGreaterThan(T element){
       int count =0;
       for (T e : list) {
           if (e.compareTo(element) > 0) {
               count++;
           }
       }
       return count;
   }
    public T getMax(){
//       T max = this.list.get(0);
//        for (int i = 1; i < this.list.size(); i++) {
//            if (this.list.get(i).compareTo(max)>0){
//                max = this.list.get(i);
//            }
//        }
//        return max;

        return Collections.max(this.list);
    }
    public T getMin(){
//        T max = this.list.get(0);
//        for (int i = 1; i < this.list.size(); i++) {
//            if (this.list.get(i).compareTo(max)<0){
//                max = this.list.get(i);
//            }
//        }
//        return max;
    return Collections.min(this.list);

    }

    public List<T> getList() {
        return this.list;
    }

    void sort() {
        this.list.sort(Comparable::compareTo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T t:this.list) {
            sb.append(t).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
