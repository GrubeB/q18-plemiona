package pl.dawid.main.resource.application.port.out;

import pl.dawid.main.resource.domain.Resource;
import pl.dawid.main.resource.domain.ResourceType;

import java.util.List;
import java.util.Optional;

public interface FetchResourcePort {
    Optional<Resource> findById(Long id);

    List<Resource> findByResourceType(ResourceType resourceType);

    List<Resource> findAll();

    Boolean existsById(Long id);
}
