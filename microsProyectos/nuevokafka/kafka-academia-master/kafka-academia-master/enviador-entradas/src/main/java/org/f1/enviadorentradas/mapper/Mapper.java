package org.f1.enviadorentradas.mapper;

public interface Mapper<T, D> {

    T dtoToEntity(D dto);

}

