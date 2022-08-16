package pl.dawid.main.resource.application;

import lombok.RequiredArgsConstructor;
import pl.dawid.main.resource.domain.Resource;
import pl.dawid.main.resource.domain.ResourceType;

@RequiredArgsConstructor
public class ResourceFactory {

    public Resource createResource(Long amount, ResourceType resourceType) {
        Resource resource = Resource.resourceWithoutId(amount, resourceType);
        return resource;
    }

    public Resource createBaseResource(ResourceType resourceType) {
        Resource resource = Resource.resourceWithoutId(0L, resourceType);
        return resource;
    }
}
