package pl.dawid.q13generic.service.root.entity.declaration;

import org.springframework.data.domain.Page;
import pl.dawid.q13generic.controller.root.criteria.SearchCriteria;

public interface FetchEntityByCriteriaServiceDeclaration<ENTITY> {
    Page<ENTITY> fetchEntityByCriteria(SearchCriteria request);
}
