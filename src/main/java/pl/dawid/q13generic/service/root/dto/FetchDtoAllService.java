package pl.dawid.q13generic.service.root.dto;

import pl.dawid.q13generic.mapper.root.DtoMapper;
import pl.dawid.q13generic.service.root.GService;
import pl.dawid.q13generic.service.root.dto.declaration.FetchDtoAllServiceDeclaration;

import java.util.List;

public interface FetchDtoAllService<ENTITY, DTO, ID> extends
        GService<ENTITY, ID>,
        FetchDtoAllServiceDeclaration<DTO> {
    default List<DTO> fetchDtoAll() {
        List<ENTITY> entityList = getRepository().findAll();
        return getMapper().mapEntityListToDtoList(entityList);
    }

    DtoMapper<ENTITY, DTO> getMapper();
}
