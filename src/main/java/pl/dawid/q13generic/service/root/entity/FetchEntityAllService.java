package pl.dawid.q13generic.service.root.entity;

import pl.dawid.q13generic.service.root.GService;
import pl.dawid.q13generic.service.root.entity.declaration.FetchEntityAllServiceDeclaration;

import java.util.List;

public interface FetchEntityAllService<ENTITY, ID> extends
        GService<ENTITY, ID>,
        FetchEntityAllServiceDeclaration<ENTITY> {
    default List<ENTITY> fetchEntityAll() {
        return getRepository().findAll();
    }
}
