package pl.dawid.q13generic.service.root.dto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.dawid.q13generic.controller.root.criteria.SearchCriteria;
import pl.dawid.q13generic.controller.root.criteria.SearchSpecification;
import pl.dawid.q13generic.mapper.root.DtoMapper;
import pl.dawid.q13generic.service.root.GService;
import pl.dawid.q13generic.service.root.dto.declaration.FetchDtoByCriteriaServiceDeclaration;

public interface FetchDtoByCriteriaService<ENTITY, DTO, ID> extends
        GService<ENTITY, ID>,
        FetchDtoByCriteriaServiceDeclaration<DTO> {
    default Page<DTO> fetchDtoByCriteria(SearchCriteria criteria) {
        SearchSpecification<ENTITY> specification = new SearchSpecification<>(criteria);
        Pageable pageable = SearchSpecification.getPageable(criteria.getPage(), criteria.getSize());
        Page<ENTITY> entityPage = getRepository().findAll(specification, pageable);
        return entityPage.map(entity -> getMapper().mapEntityToDto(entity));
    }

    DtoMapper<ENTITY, DTO> getMapper();
}
