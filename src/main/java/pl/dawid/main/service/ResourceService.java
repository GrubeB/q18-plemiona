package pl.dawid.main.service;

import pl.dawid.main.dto.resource.ResourceDto;
import pl.dawid.main.entity.resources.Resource;
import pl.dawid.main.entity.resources.ResourceType;
import pl.dawid.main.service.root.FullService;

public interface ResourceService extends FullService<Resource, ResourceDto, ResourceDto, ResourceDto, Long>{
    Resource getResourceByType(ResourceType type);
}
