package pl.dawid.q13generic.service.root.entity;

import pl.dawid.q13generic.exception.NotFoundException;
import pl.dawid.q13generic.service.root.GService;
import pl.dawid.q13generic.service.root.entity.declaration.FetchEntityByIdServiceDeclaration;

public interface FetchEntityByIdService<ENTITY, ID> extends
        GService<ENTITY, ID>,
        FetchEntityByIdServiceDeclaration<ENTITY, ID> {
    default ENTITY fetchEntityById(ID id) {
        return getRepository().findById(id).orElseThrow(() ->new NotFoundException("Not found object with id: "+id));
    }
}
