package LinkedListTraversal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by danie on 11/23/2017.
 */
public class LinkedListTraversalImpl<T> implements LinkedListTraversal<T>, Iterable<T> {

    private List<T>elements;

    public LinkedListTraversalImpl() {
        this.elements = new ArrayList<T>();
    }

    @Override
    public void add(T element) {
        this.elements.add(element);

    }

    @Override
    public boolean remove(T element) {
        return this.elements.remove(element);
    }

    @Override
    public int getSize() {
        return this.elements.size();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        LinkedListIterator iterator = new LinkedListIterator();
        while (iterator.hasNext()){
            action.accept(iterator.next());
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {

        private int index;

        public LinkedListIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index<elements.size();
        }

        @Override
        public T next() {
            return elements.get(index++);
        }
    }
}
