package pl.dawid.main.service.root.dto.declaration;

import org.springframework.data.domain.Page;
import pl.dawid.main.controller.root.criteria.SearchCriteria;

public interface FetchDtoByCriteriaServiceDeclaration<DTO> {
    Page<DTO> fetchDtoByCriteria(SearchCriteria request);
}
