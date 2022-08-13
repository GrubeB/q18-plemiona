package pl.dawid.main.service.root.dto;

import pl.dawid.main.mapper.root.DtoMapper;
import pl.dawid.main.service.root.dto.declaration.FetchDtoAllServiceDeclaration;
import pl.dawid.main.service.root.entity.FetchEntityAllService;

import java.util.List;

public interface FetchDtoAllService<ENTITY, DTO, ID> extends
        FetchEntityAllService<ENTITY, ID>,
        FetchDtoAllServiceDeclaration<DTO> {
    default List<DTO> fetchDtoAll() {
        beforeFetchDtoAll();
        List<ENTITY> entityList = fetchEntityAll();
        List<DTO> dtoList = getMapper().mapEntityListToDtoList(entityList);
        afterFetchDtoAll(dtoList);
        return dtoList;
    }

    default void beforeFetchDtoAll() {
    }

    default void afterFetchDtoAll(List<DTO> dtoList) {
    }

    DtoMapper<ENTITY, DTO> getMapper();
}
