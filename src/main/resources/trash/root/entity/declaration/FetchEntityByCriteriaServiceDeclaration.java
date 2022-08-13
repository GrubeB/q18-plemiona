package pl.dawid.main.service.root.entity.declaration;

import org.springframework.data.domain.Page;
import pl.dawid.main.controller.root.criteria.SearchCriteria;

public interface FetchEntityByCriteriaServiceDeclaration<ENTITY> {
    Page<ENTITY> fetchEntityByCriteria(SearchCriteria request);
}
