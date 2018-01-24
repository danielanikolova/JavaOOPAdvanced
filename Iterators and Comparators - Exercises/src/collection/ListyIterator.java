package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String>{

    private List<String> strings;
    private int index = 0;

    ListyIterator(String ... str) {
        this.setStrings(str);
    }

    private void setStrings(String...str) {
        if (str.length==0){
            this.strings = new ArrayList<>();
        }else {
            this.strings = new ArrayList<>(Arrays.asList(str));
        }

    }

    public void printAll(){
        for (String str:this.strings) {
            System.out.print(str + " ");
        }
    }

    public boolean move(){
        if (iterator().hasNext()){
            this.index++;
            return true;
        }else return false;
    }

    public void print(){
        if (strings.size()==0){
            throw new IllegalArgumentException("Invalid Operation!");
        }
        System.out.println(this.strings.get(this.index));
    }

    public boolean hasNext(){
        if (iterator().hasNext()){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Iterator iterator() {
        return new CurrentIterator();
    }

    private final class CurrentIterator implements Iterator<String> {

        @Override
        public boolean hasNext() {
            return index<strings.size()-1;
        }

        @Override
        public String next() {
            return strings.get(index++);
        }
    }
}
