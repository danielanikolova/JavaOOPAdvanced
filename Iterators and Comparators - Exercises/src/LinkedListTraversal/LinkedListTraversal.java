package LinkedListTraversal;

public interface LinkedListTraversal<T>extends Iterable<T> {

    void add(T element);
    boolean remove(T element);
    int getSize();

}
