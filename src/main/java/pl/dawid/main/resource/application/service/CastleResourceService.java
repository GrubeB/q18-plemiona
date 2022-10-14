package pl.dawid.main.resource.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dawid.main.castle.application.port.in.FetchCastleByIdUseCase;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.resource.application.port.in.*;
import pl.dawid.main.resource.application.port.in.dto.AddResourceCommand;
import pl.dawid.main.resource.application.port.in.dto.CreateCastleResourceCommand;
import pl.dawid.main.resource.application.port.in.dto.SubtractResourceCommand;
import pl.dawid.main.resource.application.port.out.CreateCastleResourcePort;
import pl.dawid.main.resource.application.port.out.FetchCastleResourceByIdPort;
import pl.dawid.main.resource.application.port.out.UpdateCastleResourcePort;
import pl.dawid.main.resource.domain.CastleResource;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CastleResourceService implements
        CreateCastleResourceUseCase,
        FetchAllCastleResourceUseCase,
        FetchCastleResourceByIdUseCase,
        AddResourceUseCase,
        SubtractResourceUseCase{
    private final UpdateCastleResourcePort updateCastleResourcePort;
    private final CreateCastleResourcePort createCastleResourcePort;
    private final FetchCastleResourceByIdPort fetchCastleResourceByIdPort;
    private final FetchAllCastleResourceUseCase fetchAllCastleResourceUseCase;


    private final FetchCastleByIdUseCase fetchCastleByIdUseCase;


    private final CastleResourceFactory castleResourceFactory;

    @Override
    public void addResource(Long castleResourceId, AddResourceCommand command) {
        CastleResource castleResource = fetchCastleResourceByIdPort.fetchById(castleResourceId);
        castleResource.addResourceList(command.getResourceList());
        updateCastleResourcePort.update(castleResourceId,castleResource);
    }

    @Override
    public void subtractResource(Long castleResourceId, SubtractResourceCommand command) {
        CastleResource castleResource = fetchCastleResourceByIdPort.fetchById(castleResourceId);
        castleResource.subtractResourceList(command.getResourceList());
        updateCastleResourcePort.update(castleResourceId,castleResource);
    }

    @Override
    public List<CastleResource> fetchAll() {
        return fetchAllCastleResourceUseCase.fetchAll();
    }

    @Override
    public CastleResource findById(Long id) {
        return fetchCastleResourceByIdPort.fetchById(id);
    }

    @Override
    public CastleResource create(CreateCastleResourceCommand command) {
        Castle castle = fetchCastleByIdUseCase.fetchById(command.getCastleId());
        CastleResource castleResourceFromFactory = castleResourceFactory.createCastleResource(castle);
        castle.setCastleResource(castleResourceFromFactory);
        castleResourceFromFactory.setCastle(castle);
        return createCastleResourcePort.create(castleResourceFromFactory);
    }

}
