package br.com.desafiocrud.repository;

import java.util.List;

public interface GenericRepository<T> {
    T create(T t);
    void delete(T t);
    T find(Long id);
    T update(T t);
    List<T> findAll();
}
