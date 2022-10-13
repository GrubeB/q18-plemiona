package pl.dawid.main.resource.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dawid.main.resource.adapter.out.persistence.CastleResourcePersistenceAdapter;
import pl.dawid.main.resource.application.port.in.*;
import pl.dawid.main.resource.application.port.in.dto.AddResourceCommand;
import pl.dawid.main.resource.application.port.in.dto.CreateCastleResourceCommand;
import pl.dawid.main.resource.application.port.in.dto.SubtractResourceCommand;
import pl.dawid.main.resource.domain.CastleResource;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CastleResourceService implements
        CreateCastleResourceUseCase,
        FetchCastleResourceUseCase,
        AddResourceUseCase,
        SubtractResourceUseCase{
    private final CastleResourcePersistenceAdapter castleResourcePersistenceAdapter;
    private final CastleResourceFactory castleResourceFactory;

    @Override
    public void addResource(Long castleResourceId, AddResourceCommand command) {
        CastleResource castleResource = castleResourcePersistenceAdapter.fetchById(castleResourceId);
        castleResource.addResourceList(command.getResourceList());
        castleResourcePersistenceAdapter.update(castleResourceId,castleResource);
    }

    @Override
    public void subtractResource(Long castleResourceId, SubtractResourceCommand command) {
        CastleResource castleResource = castleResourcePersistenceAdapter.fetchById(castleResourceId);
        castleResource.subtractResourceList(command.getResourceList());
        castleResourcePersistenceAdapter.update(castleResourceId,castleResource);
    }

    @Override
    public List<CastleResource> findAllCastleResource() {
        return castleResourcePersistenceAdapter.fetchAll();
    }

    @Override
    public CastleResource findCastleResourceById(Long castleResourceId) {
        return castleResourcePersistenceAdapter.fetchById(castleResourceId);
    }
    @Override
    public CastleResource createCastleResource(CreateCastleResourceCommand command) {
        CastleResource castleResourceFromFactory = castleResourceFactory.createCastleResource(command.getCastle());
        CastleResource castleResource = castleResourcePersistenceAdapter.create(castleResourceFromFactory);
        command.getCastle().setCastleResource(castleResource);
        return castleResource;
    }

}
