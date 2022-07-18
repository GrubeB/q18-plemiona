package pl.dawid.q13generic.service.root;

import pl.dawid.q13generic.service.root.dto.CreateDtoService;
import pl.dawid.q13generic.service.root.entity.CreateEntityService;

public interface CreateService<ENTITY, DTO, CreateDTO, ID> extends
        CreateEntityService<ENTITY, ID>,
        CreateDtoService<ENTITY, DTO, CreateDTO, ID> {
}
