package app.collection;


public interface Register<T> {
    Integer count();

    void enqueueEmergency(T emergency);

    T dequeueEmergency();

    Boolean isEmpty();
}
