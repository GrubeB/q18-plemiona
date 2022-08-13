package pl.dawid.main.service.root.entity;

import pl.dawid.main.service.root.GService;
import pl.dawid.main.service.root.entity.declaration.CreateEntityServiceDeclaration;

public interface CreateEntityService<ENTITY, ID> extends
        GService<ENTITY, ID>,
        CreateEntityServiceDeclaration<ENTITY> {

    default void beforeCreateEntity(ENTITY entity){
    }
    default void afterCreateEntity(ENTITY entity){
    }
    default ENTITY createEntity(ENTITY entity) {
        beforeCreateEntity(entity);
        ENTITY savedEntity = getRepository().saveAndFlush(entity);
        afterCreateEntity(savedEntity);
        return savedEntity;
    }
}
