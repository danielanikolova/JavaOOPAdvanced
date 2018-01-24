package stackIterator;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Stack<T extends String> implements IStackIterator{

    private List<String> list;

    public Stack(String...list) {
        this.setList(list);
    }

    private void setList(String... list) {
        if (list.length==0){
            this.list = new ArrayList<>();
        }else {
            this.list = new ArrayList<>(Arrays.asList(list));
        }
    }


    @Override
    public void push(String...values) {
        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }
    }

    @Override
    public void pop() {
        if (this.list.size()==0){
            throw new IllegalArgumentException("No elements");
        }
        this.list.remove(this.list.size()-1);
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = this.list.size()-1; i >=0; i--) {
            sb.append(this.list.get(i)).append("\n");
        }
        return sb.toString();
    }

    private class MyIterator implements Iterator {

        @Override
        public boolean hasNext() {
            return list.size()>1;
        }

        @Override
        public Object next() {
            return null;
        }


    }
}
