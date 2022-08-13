package pl.dawid.main.service.root;

import pl.dawid.main.service.root.dto.FetchDtoAllService;
import pl.dawid.main.service.root.dto.FetchDtoByCriteriaService;
import pl.dawid.main.service.root.dto.FetchDtoByIdlService;
import pl.dawid.main.service.root.entity.FetchEntityAllService;
import pl.dawid.main.service.root.entity.FetchEntityByCriteriaService;
import pl.dawid.main.service.root.entity.FetchEntityByIdService;

public interface FetchService<ENTITY, DTO, ID> extends
        FetchDtoAllService<ENTITY, DTO, ID>,
        FetchDtoByIdlService<ENTITY, DTO, ID>,
        FetchEntityByIdService<ENTITY, ID>,
        FetchEntityAllService<ENTITY, ID>,
        FetchDtoByCriteriaService<ENTITY, DTO, ID>,
        FetchEntityByCriteriaService<ENTITY, ID> {
}
