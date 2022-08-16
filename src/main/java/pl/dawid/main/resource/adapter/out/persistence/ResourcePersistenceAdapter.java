package pl.dawid.main.resource.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import pl.dawid.main.resource.application.port.out.CreateResourcePort;
import pl.dawid.main.resource.application.port.out.FetchResourcePort;
import pl.dawid.main.resource.application.port.out.UpdateResourcePort;
import pl.dawid.main.resource.domain.Resource;
import pl.dawid.main.resource.domain.ResourceType;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ResourcePersistenceAdapter implements
        CreateResourcePort,
        FetchResourcePort,
        UpdateResourcePort {

    private final ResourceEntityCommand command;
    private final ResourceEntityMapper mapper = ResourceEntityMapper.INSTANCE;

    @Override
    public Resource createEntity(Resource resource) {
        ResourceEntity resourceEntity = mapper.mapToJpaEntity(resource);
        ResourceEntity resourceSaved = command.saveAndFlush(resourceEntity);
        return mapper.mapToDomainObject(resourceSaved);
    }

    @Override
    public Optional<Resource> findById(Long id) {
        Optional<ResourceEntity> resourceEntity = command.findById(id);
        return resourceEntity.map(mapper::mapToDomainObject);
    }

    @Override
    public List<Resource> findByResourceType(ResourceType resourceType) {
        List<ResourceEntity> resourceEntityList = command.findAllByResourceType(resourceType);
        return mapper.mapToDomainObjectList(resourceEntityList);
    }

    @Override
    public List<Resource> findAll() {
        List<ResourceEntity> resourceEntityList = command.findAll();
        return mapper.mapToDomainObjectList(resourceEntityList);
    }

    @Override
    public void updateAddResourceAmount(Long resourceId, Long amount) {
        command.updateAddResourceAmount(resourceId, amount);
    }

    @Override
    public void updateSubtractResourceAmount(Long resourceId, Long amount) {
        command.updateSubtractResourceAmount(resourceId, amount);
    }

    @Override
    public void updateEntity(Resource resource) {
        ResourceEntity resourceEntity = mapper.mapToJpaEntity(resource);
        command.saveAndFlush(resourceEntity);
    }

    @Override
    public Boolean existsById(Long id) {
        return command.existsById(id);
    }
}
