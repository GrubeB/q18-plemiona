package pl.dawid.main.service.root;

import pl.dawid.main.service.root.dto.CreateDtoService;
import pl.dawid.main.service.root.entity.CreateEntityService;

public interface CreateService<ENTITY, DTO, CreateDTO, ID> extends
        CreateEntityService<ENTITY, ID>,
        CreateDtoService<ENTITY, DTO, CreateDTO, ID> {
}
