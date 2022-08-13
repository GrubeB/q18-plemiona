package pl.dawid.main.mapper.root;

import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

public interface CreateDtoMapper<ENTITY, CreateDTO> extends GMapper {
    @Named("mapCreateDTOToEntity")
    ENTITY mapCreateDTOToEntity(CreateDTO createDTO);

    @Named("mapEntityToCreateDTO")
    CreateDTO mapEntityToCreateDTO(ENTITY entity);

    @Named("mergeEntityWithCreateDTO")
    ENTITY mergeEntityWithCreateDTO(@MappingTarget ENTITY entity, CreateDTO createDTO);
}
