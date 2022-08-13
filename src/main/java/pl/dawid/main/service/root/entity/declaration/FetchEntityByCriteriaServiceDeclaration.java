package pl.dawid.main.service.root.entity.declaration;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.dawid.main.controller.root.criteria.SearchCriteria;

public interface FetchEntityByCriteriaServiceDeclaration<ENTITY> {
    Page<ENTITY> fetchEntityByCriteria(SearchCriteria request);

    void beforeFetchEntityByCriteria(SearchCriteria criteria, Pageable pageable);

    void afterFetchEntityByCriteria(Page<ENTITY> entityPage);
}
