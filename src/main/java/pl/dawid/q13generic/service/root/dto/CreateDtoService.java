package pl.dawid.q13generic.service.root.dto;

import pl.dawid.q13generic.mapper.root.CreateDtoMapper;
import pl.dawid.q13generic.mapper.root.DtoMapper;
import pl.dawid.q13generic.service.root.GService;
import pl.dawid.q13generic.service.root.dto.declaration.CreateDtoServiceDeclaration;

public interface CreateDtoService<ENTITY, DTO, CreateDTO, ID> extends
        GService<ENTITY, ID>,
        CreateDtoServiceDeclaration<DTO, CreateDTO> {
    default DTO createDto(CreateDTO createDTO) {
        ENTITY entity = getCreateMapper().mapCreateDTOToEntity(createDTO);
        ENTITY createdEntity = getRepository().saveAndFlush(entity);
        return getMapper().mapEntityToDto(createdEntity);
    }

    CreateDtoMapper<ENTITY, CreateDTO> getCreateMapper();

    DtoMapper<ENTITY, DTO> getMapper();
}
