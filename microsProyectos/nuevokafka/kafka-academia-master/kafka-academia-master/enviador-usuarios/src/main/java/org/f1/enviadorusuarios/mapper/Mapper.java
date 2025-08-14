package org.f1.enviadorusuarios.mapper;

public interface Mapper<T, D> {

    T dtoToEntity(D dto);

}

