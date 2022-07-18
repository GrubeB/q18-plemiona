package pl.dawid.q13generic.controller.root;


import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.dawid.q13generic.controller.root.declaration.FetchByCriteriaControllerDeclaration;
import pl.dawid.q13generic.controller.root.criteria.SearchCriteria;
import pl.dawid.q13generic.service.root.dto.FetchDtoByCriteriaService;

public interface FetchByCriteriaController<ENTITY, DTO, ID> extends
        GController,
        FetchByCriteriaControllerDeclaration<DTO, ID> {
    @GetMapping("/criteria")
    default Page<DTO> fetchByCriteria(@RequestBody SearchCriteria criteria) {
        return getService().fetchDtoByCriteria(criteria);
    }

    FetchDtoByCriteriaService<ENTITY, DTO, ID> getService();
}
