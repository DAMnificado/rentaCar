package org.example.service;

import java.util.ArrayList;

public interface ICrudService<T> {

    void add(T t);
    void deleteById(Long id);
    ArrayList findAll();
    void update(T t);

}
