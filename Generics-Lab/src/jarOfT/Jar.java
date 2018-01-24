package jarOfT;

import java.util.ArrayDeque;
import java.util.Deque;

public class  Jar <T>{

    private Deque<T> contents;

    public Jar() {
        this.contents = new ArrayDeque<T>();
    }

    public void add(T element){
        this.contents.push(element);
    }
    public T remove(){
        return this.contents.pop();
    }

}
