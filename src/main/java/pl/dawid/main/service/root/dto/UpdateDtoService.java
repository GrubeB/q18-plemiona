package pl.dawid.main.service.root.dto;

import pl.dawid.main.entity.root.GEntity;
import pl.dawid.main.exception.NotFoundException;
import pl.dawid.main.mapper.root.DtoMapper;
import pl.dawid.main.mapper.root.UpdateDtoMapper;
import pl.dawid.main.service.root.dto.declaration.UpdateDtoByIdServiceDeclaration;
import pl.dawid.main.service.root.entity.UpdateEntityService;

public interface UpdateDtoService<ENTITY extends GEntity<ID>, DTO, UpdateDTO, ID> extends
        UpdateEntityService<ENTITY, ID>,
        UpdateDtoByIdServiceDeclaration<DTO, UpdateDTO, ID> {
    default DTO updateDto(ID id, UpdateDTO updateDTO) {
        beforeUpdateDto(id, updateDTO);
        ENTITY existingEntity = getRepository().findById(id).orElseThrow(() -> new NotFoundException("Not found object with id: " + id));
        ENTITY mergedEntity = getUpdateMapper().mergeEntityWithUpdateDTO(existingEntity, updateDTO);
        ENTITY updatedEntity = updateEntity(id, mergedEntity);
        DTO dto = getMapper().mapEntityToDto(updatedEntity);
        afterUpdateDto(id, dto);
        return dto;
    }

    default void beforeUpdateDto(ID id, UpdateDTO updateDTO) {
    }

    default void afterUpdateDto(ID id, DTO dto) {
    }

    UpdateDtoMapper<ENTITY, UpdateDTO> getUpdateMapper();

    DtoMapper<ENTITY, DTO> getMapper();
}
