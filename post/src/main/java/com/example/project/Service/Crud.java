package com.example.project.Service;

import java.util.List;

public interface Crud<D,I>{
    D create(D dto);
    List<D> getAll();
    D getById(I id);
    D update(I id ,D dto);
    D delte(I id );


}
