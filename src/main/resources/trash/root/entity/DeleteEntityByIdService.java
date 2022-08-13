package pl.dawid.main.service.root.entity;

import pl.dawid.main.exception.NotFoundException;
import pl.dawid.main.service.root.GService;
import pl.dawid.main.service.root.entity.declaration.DeleteEntityByIdServiceDeclaration;

public interface DeleteEntityByIdService<ENTITY, ID> extends
        GService<ENTITY, ID>,
        DeleteEntityByIdServiceDeclaration<ID> {
    default void deleteEntityById(ID id) {
        getRepository().findById(id).orElseThrow(() ->  new NotFoundException("Not found object with id: "+id));
        getRepository().deleteById(id);
    }
}