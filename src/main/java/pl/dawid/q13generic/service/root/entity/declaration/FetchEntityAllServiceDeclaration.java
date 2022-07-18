package pl.dawid.q13generic.service.root.entity.declaration;

import java.util.List;

public interface FetchEntityAllServiceDeclaration<ENTITY> {
    List<ENTITY> fetchEntityAll();
}
