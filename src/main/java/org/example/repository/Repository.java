package org.example.repository;

import java.util.List;

public interface Repository<T> {

    void add(T type);

    List<T> getAll();

    void deleteAll();
}
