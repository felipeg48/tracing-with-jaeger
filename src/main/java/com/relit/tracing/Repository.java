package com.relit.tracing;

public interface Repository <T,ID> {
    T save(T entity);
    T findById(ID id);
    void deleteById(ID id);
    Iterable<T> findAll();
}
