package com.hadicha.zeonshop.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class AbstractMapper<E,D> {
    @Autowired
    private ModelMapper mapper;
    private final Class<E> entityClass;
    private final Class<D> dtoClass;

    public AbstractMapper(Class<E> entityClass, Class<D> dtoClass) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    public E toEntity(D dto) {
        return Objects.isNull(entityClass) ? null : mapper.map(dto, entityClass);
    }

    public D toDto(E entity) {
        return Objects.isNull(entityClass) ? null : mapper.map(entity, dtoClass);
    }

}
