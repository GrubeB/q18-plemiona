package pl.dawid.q13generic.mapper.root;

public interface FullDtoMapper<ENTITY, DTO, UpdateDTO, CreateDTO> extends
        DtoMapper<ENTITY, DTO>,
        UpdateDtoMapper<ENTITY, UpdateDTO>,
        CreateDtoMapper<ENTITY, CreateDTO> {
}
