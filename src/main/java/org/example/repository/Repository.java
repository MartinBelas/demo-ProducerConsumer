package org.example.repository;

import java.util.stream.Stream;

public interface Repository<T> {

    void add(T type);

    Stream<T> getAll();

    void deleteAll();
}
