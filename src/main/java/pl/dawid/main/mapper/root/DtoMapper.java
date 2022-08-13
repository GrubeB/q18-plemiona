package pl.dawid.main.mapper.root;

import java.util.List;
import java.util.Set;

public interface DtoMapper<ENTITY, IdDTO> extends GMapper {
    IdDTO mapEntityToDto(ENTITY entity);

    ENTITY mapDtoToEntity(IdDTO dto);

    Set<IdDTO> mapEntitySetToDtoSet(Set<ENTITY> entitySet);

    Set<ENTITY> mapDtoSetToEntitySet(Set<IdDTO> dtoSet);

    List<IdDTO> mapEntityListToDtoList(List<ENTITY> entityList);

    List<ENTITY> mapDtoListToEntityList(List<IdDTO> dtoList);
}
