package com.Babaitis.Project.ProblemStore.common.mapper;

public interface Mapper<E, DTO> {

    DTO toDto(E entity);
    E fromDto(DTO dto);
}
