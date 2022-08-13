package pl.dawid.main.controller.root;

import pl.dawid.main.entity.root.GEntity;
import pl.dawid.main.service.root.FetchService;

public interface FetchController<ENTITY extends GEntity<ID>, DTO, ID> extends
        FetchAllController<ENTITY, DTO, ID>,
        FetchByIdController<ENTITY, DTO, ID>,
        FetchByCriteriaController<ENTITY, DTO, ID> {
    FetchService<ENTITY, DTO, ID> getService();
}
