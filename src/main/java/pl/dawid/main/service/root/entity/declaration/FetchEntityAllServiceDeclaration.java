package pl.dawid.main.service.root.entity.declaration;

import java.util.List;

public interface FetchEntityAllServiceDeclaration<ENTITY> {
    List<ENTITY> fetchEntityAll();
    void beforeFetchEntityAll();
    void afterFetchEntityAll(List<ENTITY> entityList);
}
