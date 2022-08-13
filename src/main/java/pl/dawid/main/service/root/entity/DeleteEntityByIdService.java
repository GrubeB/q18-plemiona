package pl.dawid.main.service.root.entity;

import pl.dawid.main.exception.NotFoundException;
import pl.dawid.main.service.root.GService;
import pl.dawid.main.service.root.entity.declaration.DeleteEntityByIdServiceDeclaration;

public interface DeleteEntityByIdService<ENTITY, ID> extends
        GService<ENTITY, ID>,
        DeleteEntityByIdServiceDeclaration<ID, ENTITY> {
    default void deleteEntityById(ID id) {
        ENTITY existingEntity = getRepository().findById(id).orElseThrow(() -> new NotFoundException("Not found object with id: " + id));
        beforeDeleteEntity(id, existingEntity);
        getRepository().deleteById(id);
        afterDeleteEntity(id);
    }

    default void beforeDeleteEntity(ID id, ENTITY existingEntity) {
    }

    default void afterDeleteEntity(ID id) {
    }
}