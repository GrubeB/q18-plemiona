package pl.dawid.main.service.root.dto;

import org.springframework.data.domain.Page;
import pl.dawid.main.controller.root.criteria.SearchCriteria;
import pl.dawid.main.mapper.root.DtoMapper;
import pl.dawid.main.service.root.dto.declaration.FetchDtoByCriteriaServiceDeclaration;
import pl.dawid.main.service.root.entity.FetchEntityByCriteriaService;

public interface FetchDtoByCriteriaService<ENTITY, DTO, ID> extends
        FetchEntityByCriteriaService<ENTITY, ID>,
        FetchDtoByCriteriaServiceDeclaration<DTO> {
    default Page<DTO> fetchDtoByCriteria(SearchCriteria criteria) {
        beforeFetchDtoByCriteria(criteria);
        Page<ENTITY> entityPage = fetchEntityByCriteria(criteria);
        Page<DTO> dto = entityPage.map(entity -> getMapper().mapEntityToDto(entity));
        afterFetchDtoByCriteria(dto);
        return dto;
    }

    default void beforeFetchDtoByCriteria(SearchCriteria criteria) {
    }

    default void afterFetchDtoByCriteria(Page<DTO> dto) {
    }

    DtoMapper<ENTITY, DTO> getMapper();
}
