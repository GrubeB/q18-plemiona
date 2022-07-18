package pl.dawid.q13generic.service.root;

import pl.dawid.q13generic.service.root.dto.FetchDtoAllService;
import pl.dawid.q13generic.service.root.dto.FetchDtoByIdlService;
import pl.dawid.q13generic.service.root.entity.FetchEntityAllService;
import pl.dawid.q13generic.service.root.entity.FetchEntityByIdService;

public interface FetchService<ENTITY, DTO, ID> extends
        FetchDtoAllService<ENTITY, DTO, ID>,
        FetchDtoByIdlService<ENTITY, DTO, ID>,
        FetchEntityByIdService<ENTITY, ID>,
        FetchEntityAllService<ENTITY, ID> {
}
