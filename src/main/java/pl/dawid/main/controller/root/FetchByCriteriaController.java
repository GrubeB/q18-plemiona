package pl.dawid.main.controller.root;


import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.dawid.main.controller.root.declaration.FetchByCriteriaControllerDeclaration;
import pl.dawid.main.controller.root.criteria.SearchCriteria;
import pl.dawid.main.service.root.dto.FetchDtoByCriteriaService;

public interface FetchByCriteriaController<ENTITY, DTO, ID> extends
        GController,
        FetchByCriteriaControllerDeclaration<DTO, ID> {
    @GetMapping("/criteria")
    default Page<DTO> fetchByCriteria(@RequestBody SearchCriteria criteria) {
        return getService().fetchDtoByCriteria(criteria);
    }

    FetchDtoByCriteriaService<ENTITY, DTO, ID> getService();
}
