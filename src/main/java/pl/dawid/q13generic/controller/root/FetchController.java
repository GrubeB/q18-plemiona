package pl.dawid.q13generic.controller.root;

import pl.dawid.q13generic.entity.root.GEntity;
import pl.dawid.q13generic.service.root.FetchService;

public interface FetchController<ENTITY extends GEntity<ID>, DTO, ID> extends
        FetchAllController<ENTITY, DTO, ID>,
        FetchByIdController<ENTITY, DTO, ID>,
        FetchByCriteriaController<ENTITY, DTO, ID> {
    FetchService<ENTITY, DTO, ID> getService();
}
