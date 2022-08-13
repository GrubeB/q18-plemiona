package pl.dawid.main.service.root.entity;

import pl.dawid.main.entity.root.GEntity;
import pl.dawid.main.exception.NotFoundException;
import pl.dawid.main.service.root.GService;
import pl.dawid.main.service.root.entity.declaration.UpdateEntityServiceDeclaration;

public interface UpdateEntityService<ENTITY extends GEntity<ID>, ID> extends
        GService<ENTITY, ID>,
        UpdateEntityServiceDeclaration<ENTITY, ID> {
    default ENTITY updateEntity(ID id, ENTITY entity) {
        if (!getRepository().existsById(id)) {
            throw new NotFoundException("Not found object with id: "+id);
        }
        return getRepository().saveAndFlush(entity);
    }
}