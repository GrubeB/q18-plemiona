package pl.dawid.main.controller.root.declaration;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import pl.dawid.main.controller.root.criteria.SearchCriteria;

public interface FetchByCriteriaControllerDeclaration<DTO, ID> {
    Page<DTO> fetchByCriteria(@RequestBody SearchCriteria request);
}
