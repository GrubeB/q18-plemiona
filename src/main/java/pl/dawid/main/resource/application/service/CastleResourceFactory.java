package pl.dawid.main.resource.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.resource.domain.CastleResource;
import pl.dawid.main.resource.domain.Resource;
import pl.dawid.main.resource.domain.ResourceType;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CastleResourceFactory {

    public CastleResource createCastleResource(Castle castle) {
        Map<ResourceType, Resource> resourceMap = new HashMap<>();
        Resource WOOD = Resource.resourceWithoutId(0L, 100000L, 10.0, ResourceType.WOOD);
        Resource CLAY = Resource.resourceWithoutId(0L, 100000L, 10.0, ResourceType.CLAY);
        Resource IRON = Resource.resourceWithoutId(0L, 100000L, 10.0, ResourceType.IRON);
        Resource EMPLOYEE = Resource.resourceWithoutId(0L, 100000L, 10.0, ResourceType.EMPLOYEE);

        resourceMap.put(ResourceType.WOOD, WOOD);
        resourceMap.put(ResourceType.CLAY, CLAY);
        resourceMap.put(ResourceType.IRON, IRON);
        resourceMap.put(ResourceType.EMPLOYEE, EMPLOYEE);

        CastleResource castleResource = CastleResource.resourceWithoutId(LocalDateTime.now(), castle, resourceMap);
        return castleResource;
    }
}
