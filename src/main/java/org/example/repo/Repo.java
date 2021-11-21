package org.example.repo;

import java.util.stream.Stream;

public interface Repo<T> {

    void add(T type);

    Stream<T> getAll();

    void deleteAll();
}
