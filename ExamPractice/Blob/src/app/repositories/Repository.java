package app.repositories;


import app.interfaces.Blob;

import java.util.Map;

public interface Repository<T> {
    void add(T element);

    void add(Blob blob);

    Blob findByName(String name);

    Map<String, T> findAll();
}
