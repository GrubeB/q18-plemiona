package pl.dawid.main.controller.root;

import pl.dawid.main.entity.root.GEntity;
import pl.dawid.main.service.root.FullService;

public interface FullController<ENTITY extends GEntity<ID>, DTO, UpdateDTO, CreateDTO, ID> extends
        FetchController<ENTITY, DTO, ID>,
        DeleteController<ENTITY, ID>,
        UpdateController<ENTITY, DTO, UpdateDTO, ID>,
        CreateController<ENTITY, DTO, CreateDTO, ID> {
    FullService<ENTITY, DTO, UpdateDTO, CreateDTO, ID> getService();
}
