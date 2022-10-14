package pl.dawid.main.castle.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dawid.main.castle.adapter.out.persistence.CastlePersistenceAdapter;
import pl.dawid.main.castle.application.port.in.CreateCastleCommand;
import pl.dawid.main.castle.application.port.in.CreateCastleUseCase;
import pl.dawid.main.castle.application.port.in.FetchAllCastleUseCase;
import pl.dawid.main.castle.application.port.in.FetchByIdUseCase;
import pl.dawid.main.castle.application.port.out.CreateCastlePort;
import pl.dawid.main.castle.application.port.out.FetchAllCastlePort;
import pl.dawid.main.castle.application.port.out.FetchCastleByIdPort;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.resource.adapter.out.persistence.CastleResourcePersistenceAdapter;
import pl.dawid.main.resource.application.port.in.AddResourceUseCase;
import pl.dawid.main.resource.application.port.in.CreateCastleResourceUseCase;
import pl.dawid.main.resource.application.port.in.FetchCastleResourceUseCase;
import pl.dawid.main.resource.application.port.in.SubtractResourceUseCase;
import pl.dawid.main.resource.application.port.in.dto.AddResourceCommand;
import pl.dawid.main.resource.application.port.in.dto.CreateCastleResourceCommand;
import pl.dawid.main.resource.application.port.in.dto.SubtractResourceCommand;
import pl.dawid.main.resource.application.service.CastleResourceFactory;
import pl.dawid.main.resource.domain.CastleResource;
import pl.dawid.main.structure.CastleStructure;
import pl.dawid.main.structure.application.port.in.CreateCastleStructurePort;
import pl.dawid.main.structure.application.port.in.dto.CreateCastleStructureCommand;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CastleService implements
        CreateCastleUseCase,
        FetchAllCastleUseCase,
        FetchByIdUseCase {

    private final CreateCastlePort createCastlePort;
    private final FetchAllCastlePort fetchAllCastlePort;
    private final FetchCastleByIdPort fetchCastleByIdPort;


    private final CreateCastleResourceUseCase createCastleResourceUseCase;
    private final CreateCastleStructurePort createCastleStructurePort;


    private final CastleFactory castleFactory;

    @Override
    public Castle create(CreateCastleCommand command) {
        Castle castle = castleFactory.createCastle(command.getName());

        CastleResource castleResource = createCastleResourceUseCase.createCastleResource(new CreateCastleResourceCommand(castle));
        castle.setCastleResource(castleResource);

        CastleStructure castleStructure = createCastleStructurePort.createCastleStructure(new CreateCastleStructureCommand(castle));
        castle.setCastleStructure(castleStructure);

        return createCastlePort.create(castle);
    }

    @Override
    public List<Castle> fetchAll() {
        return fetchAllCastlePort.fetchAll();
    }

    @Override
    public Castle fetchById(Long id) {
        return fetchCastleByIdPort.fetchById(id);
    }

}
