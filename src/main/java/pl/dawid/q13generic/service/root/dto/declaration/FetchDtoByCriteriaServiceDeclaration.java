package pl.dawid.q13generic.service.root.dto.declaration;

import org.springframework.data.domain.Page;
import pl.dawid.q13generic.controller.root.criteria.SearchCriteria;

public interface FetchDtoByCriteriaServiceDeclaration<DTO> {
    Page<DTO> fetchDtoByCriteria(SearchCriteria request);
}
