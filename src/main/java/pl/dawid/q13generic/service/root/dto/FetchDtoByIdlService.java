package pl.dawid.q13generic.service.root.dto;

import pl.dawid.q13generic.exception.NotFoundException;
import pl.dawid.q13generic.mapper.root.DtoMapper;
import pl.dawid.q13generic.service.root.GService;
import pl.dawid.q13generic.service.root.dto.declaration.FetchDtoByIdServiceDeclaration;

public interface FetchDtoByIdlService<ENTITY, DTO, ID> extends
        GService<ENTITY, ID>,
        FetchDtoByIdServiceDeclaration<DTO, ID> {
    default DTO fetchDtoById(ID id) {
        ENTITY entity = getRepository().findById(id).orElseThrow(() ->  new NotFoundException("Not found object with id: "+id));
        return getMapper().mapEntityToDto(entity);
    }

    DtoMapper<ENTITY, DTO> getMapper();
}
