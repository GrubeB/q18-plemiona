package pl.dawid.main.service.root.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.dawid.main.controller.root.criteria.SearchCriteria;
import pl.dawid.main.controller.root.criteria.SearchSpecification;
import pl.dawid.main.service.root.GService;
import pl.dawid.main.service.root.entity.declaration.FetchEntityByCriteriaServiceDeclaration;

public interface FetchEntityByCriteriaService<ENTITY, ID> extends
        GService<ENTITY, ID>,
        FetchEntityByCriteriaServiceDeclaration<ENTITY> {
    default Page<ENTITY> fetchEntityByCriteria(SearchCriteria criteria) {
        SearchSpecification<ENTITY> specification = new SearchSpecification<>(criteria);
        Pageable pageable = SearchSpecification.getPageable(criteria.getPage(), criteria.getSize());
        return getRepository().findAll(specification, pageable);
    }
}
