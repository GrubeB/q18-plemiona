package pl.dawid.main.service.root;

import pl.dawid.main.service.root.dto.FetchDtoAllService;
import pl.dawid.main.service.root.dto.FetchDtoByCriteriaService;
import pl.dawid.main.service.root.dto.FetchDtoByIdlService;

public interface FetchService<ENTITY, DTO, ID> extends
        //FetchEntityByIdService<ENTITY, ID>,
        //FetchEntityAllService<ENTITY, ID>,
        //FetchEntityByCriteriaService<ENTITY, ID>
        FetchDtoAllService<ENTITY, DTO, ID>,
        FetchDtoByIdlService<ENTITY, DTO, ID>,
        FetchDtoByCriteriaService<ENTITY, DTO, ID> {
}
