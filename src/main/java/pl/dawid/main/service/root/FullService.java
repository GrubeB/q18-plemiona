package pl.dawid.main.service.root;

import pl.dawid.main.entity.root.GEntity;

public interface FullService<ENTITY extends GEntity<ID>, DTO, UpdateDTO, CreateDTO, ID> extends
        FetchService<ENTITY, DTO, ID>,
        DeleteService<ENTITY, ID>,
        CreateService<ENTITY, DTO, CreateDTO, ID>,
        UpdateService<ENTITY, DTO, UpdateDTO, ID> {
}
