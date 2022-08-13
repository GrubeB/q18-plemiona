package pl.dawid.main.service.root.dto;

import pl.dawid.main.exception.NotFoundException;
import pl.dawid.main.mapper.root.DtoMapper;
import pl.dawid.main.service.root.GService;
import pl.dawid.main.service.root.dto.declaration.FetchDtoByIdServiceDeclaration;

public interface FetchDtoByIdlService<ENTITY, DTO, ID> extends
        GService<ENTITY, ID>,
        FetchDtoByIdServiceDeclaration<DTO, ID> {
    default DTO fetchDtoById(ID id) {
        ENTITY entity = getRepository().findById(id).orElseThrow(() ->  new NotFoundException("Not found object with id: "+id));
        return getMapper().mapEntityToDto(entity);
    }

    DtoMapper<ENTITY, DTO> getMapper();
}
