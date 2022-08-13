package pl.dawid.main.service.root;

import pl.dawid.main.entity.root.GEntity;
import pl.dawid.main.service.root.dto.UpdateDtoService;
import pl.dawid.main.service.root.entity.UpdateEntityService;

public interface UpdateService<ENTITY extends GEntity<ID>, DTO, UpdateDTO, ID> extends
        UpdateEntityService<ENTITY, ID>,
        UpdateDtoService<ENTITY, DTO, UpdateDTO, ID> {
}
