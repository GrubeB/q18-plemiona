package pl.dawid.q13generic.service.root.entity;

import pl.dawid.q13generic.exception.NotFoundException;
import pl.dawid.q13generic.service.root.GService;
import pl.dawid.q13generic.service.root.entity.declaration.DeleteEntityByIdServiceDeclaration;

public interface DeleteEntityByIdService<ENTITY, ID> extends
        GService<ENTITY, ID>,
        DeleteEntityByIdServiceDeclaration<ID> {
    default void deleteEntityById(ID id) {
        getRepository().findById(id).orElseThrow(() ->  new NotFoundException("Not found object with id: "+id));
        getRepository().deleteById(id);
    }
}