package pl.dawid.main.resource.application.port.out;

import pl.dawid.main.resource.domain.Resource;

public interface CreateResourcePort {
    Resource createEntity(Resource resource);
}
