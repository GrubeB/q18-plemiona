package pl.dawid.main.service.root.entity;

import pl.dawid.main.exception.NotFoundException;
import pl.dawid.main.service.root.GService;
import pl.dawid.main.service.root.entity.declaration.FetchEntityByIdServiceDeclaration;

public interface FetchEntityByIdService<ENTITY, ID> extends
        GService<ENTITY, ID>,
        FetchEntityByIdServiceDeclaration<ENTITY, ID> {
    default ENTITY fetchEntityById(ID id) {
        beforeFetchEntityById(id);
        ENTITY entity = getRepository().findById(id).orElseThrow(() -> new NotFoundException("Not found object with id: " + id));
        afterFetchEntityById(id, entity);
        return entity;
    }

    default void beforeFetchEntityById(ID id) {
    }

    default void afterFetchEntityById(ID id, ENTITY entity) {
    }
}
