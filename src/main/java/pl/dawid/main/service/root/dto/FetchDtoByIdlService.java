package pl.dawid.main.service.root.dto;

import pl.dawid.main.mapper.root.DtoMapper;
import pl.dawid.main.service.root.dto.declaration.FetchDtoByIdServiceDeclaration;
import pl.dawid.main.service.root.entity.FetchEntityByIdService;

public interface FetchDtoByIdlService<ENTITY, DTO, ID> extends
        FetchEntityByIdService<ENTITY, ID>,
        FetchDtoByIdServiceDeclaration<DTO, ID> {
    default DTO fetchDtoById(ID id) {
        beforeFetchDtoById(id);
        ENTITY entity = fetchEntityById(id);
        DTO dto = getMapper().mapEntityToDto(entity);
        afterFetchDtoById(id, dto);
        return dto;
    }

    default void beforeFetchDtoById(ID id) {
    }

    default void afterFetchDtoById(ID id, DTO dto) {
    }

    DtoMapper<ENTITY, DTO> getMapper();
}
