package pl.dawid.q13generic.service.root.dto;

import pl.dawid.q13generic.exception.NotFoundException;
import pl.dawid.q13generic.mapper.root.DtoMapper;
import pl.dawid.q13generic.mapper.root.UpdateDtoMapper;
import pl.dawid.q13generic.service.root.GService;
import pl.dawid.q13generic.service.root.dto.declaration.UpdateDtoByIdServiceDeclaration;

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
