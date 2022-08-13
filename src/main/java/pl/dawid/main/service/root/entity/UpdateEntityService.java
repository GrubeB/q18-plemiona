package pl.dawid.main.service.root.entity;

import pl.dawid.main.entity.root.GEntity;
import pl.dawid.main.exception.NotFoundException;
import pl.dawid.main.service.root.GService;
import pl.dawid.main.service.root.entity.declaration.UpdateEntityServiceDeclaration;

public interface UpdateEntityService<ENTITY extends GEntity<ID>, ID> extends
        GService<ENTITY, ID>,
        UpdateEntityServiceDeclaration<ENTITY, ID> {
    default ENTITY updateEntity(ID id, ENTITY newEntity) {
        ENTITY existingEntity = getRepository().findById(id).orElseThrow(() -> new NotFoundException("Not found object with id: " + id));
        beforeUpdateEntity(id, existingEntity, newEntity);
        ENTITY savedEntity = getRepository().saveAndFlush(newEntity);
        afterUpdateEntity(id, savedEntity, existingEntity);
        return savedEntity;
    }

    default void beforeUpdateEntity(ID id, ENTITY existingEntity, ENTITY newEntity) {
    }

    default void afterUpdateEntity(ID id, ENTITY savedEntity, ENTITY oldEntity) {
    }
}