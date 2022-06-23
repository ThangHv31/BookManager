package com.vmo.bookmanager.service;

import java.util.List;

public interface IBaseService <D>{
    D create(D e);
    D findById(String id);
    List<D> findAll();
    D update(String id, D dto);
    String delete(String id);

}
