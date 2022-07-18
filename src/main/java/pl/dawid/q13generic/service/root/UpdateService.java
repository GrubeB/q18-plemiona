package pl.dawid.q13generic.service.root;

import pl.dawid.q13generic.entity.root.GEntity;
import pl.dawid.q13generic.service.root.dto.UpdateDtoService;
import pl.dawid.q13generic.service.root.entity.UpdateEntityService;

public interface UpdateService<ENTITY extends GEntity<ID>, DTO, UpdateDTO, ID> extends
        UpdateEntityService<ENTITY, ID>,
        UpdateDtoService<ENTITY, DTO, UpdateDTO, ID> {
}
