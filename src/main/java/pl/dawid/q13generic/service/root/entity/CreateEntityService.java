package pl.dawid.q13generic.service.root.entity;

import pl.dawid.q13generic.service.root.GService;
import pl.dawid.q13generic.service.root.entity.declaration.CreateEntityServiceDeclaration;

public interface CreateEntityService<ENTITY, ID> extends
        GService<ENTITY, ID>,
        CreateEntityServiceDeclaration<ENTITY> {
    default ENTITY createEntity(ENTITY entity) {
        return getRepository().save(entity);
    }
}
