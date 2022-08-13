package pl.dawid.main.service.root;

import pl.dawid.main.service.root.dto.CreateDtoService;

public interface CreateService<ENTITY, DTO, CreateDTO, ID> extends
        //CreateEntityService<ENTITY, ID>,
        CreateDtoService<ENTITY, DTO, CreateDTO, ID> {
}
