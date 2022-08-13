package pl.dawid.main.service.root.dto;

import pl.dawid.main.mapper.root.CreateDtoMapper;
import pl.dawid.main.mapper.root.DtoMapper;
import pl.dawid.main.service.root.GService;
import pl.dawid.main.service.root.dto.declaration.CreateDtoServiceDeclaration;
import pl.dawid.main.service.root.entity.CreateEntityService;

public interface CreateDtoService<ENTITY, DTO, CreateDTO, ID> extends
        GService<ENTITY, ID>,
        CreateEntityService<ENTITY, ID>,
        CreateDtoServiceDeclaration<DTO, CreateDTO> {

    default void beforeCreateDto(CreateDTO createDto){
    }
    default void afterCreateDto(DTO dto){
    }
    default DTO createDto(CreateDTO createDTO) {
        beforeCreateDto(createDTO);
        ENTITY entity = getCreateMapper().mapCreateDTOToEntity(createDTO);

        ENTITY createdEntity = createEntity(entity);
        //ENTITY createdEntity = getRepository().saveAndFlush(entity);

        DTO dto = getMapper().mapEntityToDto(createdEntity);
        afterCreateDto(dto);
        return dto;
    }

    CreateDtoMapper<ENTITY, CreateDTO> getCreateMapper();

    DtoMapper<ENTITY, DTO> getMapper();
}
