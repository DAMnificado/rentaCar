package org.example.repository;

import java.util.ArrayList;

public interface ICrudRepository<T> {

    void add(T t);
    void deleteById(Long id);
    ArrayList findAll();
    T findById(Long id);
    void update(T t);

}
