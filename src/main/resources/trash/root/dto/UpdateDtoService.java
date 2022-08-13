package pl.dawid.main.service.root.dto;

import pl.dawid.main.exception.NotFoundException;
import pl.dawid.main.mapper.root.DtoMapper;
import pl.dawid.main.mapper.root.UpdateDtoMapper;
import pl.dawid.main.service.root.GService;
import pl.dawid.main.service.root.dto.declaration.UpdateDtoByIdServiceDeclaration;

public interface UpdateDtoService<ENTITY, DTO, UpdateDTO, ID> extends
        GService<ENTITY, ID>,
        UpdateDtoByIdServiceDeclaration<DTO, UpdateDTO, ID> {
    default DTO updateDto(ID id, UpdateDTO updateDTO) {
        ENTITY existingEntity = getRepository().findById(id).orElseThrow(() -> new NotFoundException("Not found object with id: "+id));
        ENTITY mergedEntity = getUpdateMapper().mergeEntityWithUpdateDTO(existingEntity, updateDTO);
        ENTITY savedEntity = getRepository().save(mergedEntity);
        return getMapper().mapEntityToDto(savedEntity);
    }

    UpdateDtoMapper<ENTITY, UpdateDTO> getUpdateMapper();

    DtoMapper<ENTITY, DTO> getMapper();
}
