package pl.dawid.main.service.root.entity;

import pl.dawid.main.service.root.GService;
import pl.dawid.main.service.root.entity.declaration.FetchEntityAllServiceDeclaration;

import java.util.List;

public interface FetchEntityAllService<ENTITY, ID> extends
        GService<ENTITY, ID>,
        FetchEntityAllServiceDeclaration<ENTITY> {
    default List<ENTITY> fetchEntityAll() {
        return getRepository().findAll();
    }
}
