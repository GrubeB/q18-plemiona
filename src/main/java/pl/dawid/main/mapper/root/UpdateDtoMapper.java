package pl.dawid.main.mapper.root;

import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

public interface UpdateDtoMapper<ENTITY, UpdateDTO> extends GMapper {
    @Named("mapUpdateDTOToEntity")
    ENTITY mapUpdateDTOToEntity(UpdateDTO updateDTO);

    @Named("mapEntityToUpdateDTO")
    UpdateDTO mapEntityToUpdateDTO(ENTITY entity);

    @Named("mergeEntityWithUpdateDTO")
    ENTITY mergeEntityWithUpdateDTO(@MappingTarget ENTITY entity, UpdateDTO updateDTO);
}
