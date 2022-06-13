package com.vmo.bookmanager.service;

import java.util.List;

public interface IBaseService <E>{
    E create(E e);
    E findById(String id);
    List<E> findAll();
//    E update(String id);
    void delete(String id);

}
