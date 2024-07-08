package org.springframework.boot.exam.Mapper;

public interface MapperTogether<E,D> {
    D  entityDto(E e);
    E dtoEntity(D d);
}