package pl.dawid.main.resource.application.port.out;

import pl.dawid.main.resource.domain.Resource;

public interface UpdateResourcePort {
    void updateAddResourceAmount(Long resourceId, Long amount);

    void updateSubtractResourceAmount(Long resourceId, Long amount);

    void updateEntity(Resource resource);
}
