package pl.dawid.main.castle.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dawid.main.castle.application.port.in.CreateCastleCommand;
import pl.dawid.main.castle.application.port.in.CreateCastleUseCase;
import pl.dawid.main.castle.application.port.in.FetchAllCastleUseCase;
import pl.dawid.main.castle.application.port.in.FetchCastleByIdUseCase;
import pl.dawid.main.castle.application.port.out.CreateCastlePort;
import pl.dawid.main.castle.application.port.out.FetchAllCastlePort;
import pl.dawid.main.castle.application.port.out.FetchCastleByIdPort;
import pl.dawid.main.castle.application.port.out.UpdateCastlePort;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.resource.application.port.in.CreateCastleResourceUseCase;
import pl.dawid.main.resource.application.port.in.dto.CreateCastleResourceCommand;
import pl.dawid.main.resource.domain.CastleResource;
import pl.dawid.main.structure.CastleStructure;
import pl.dawid.main.structure.application.port.in.CreateCastleStructureUseCase;
import pl.dawid.main.structure.application.port.in.dto.CreateCastleStructureCommand;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CastleService implements
        CreateCastleUseCase,
        FetchAllCastleUseCase,
        FetchCastleByIdUseCase {

    private final CreateCastlePort createCastlePort;
    private final FetchAllCastlePort fetchAllCastlePort;
    private final FetchCastleByIdPort fetchCastleByIdPort;
    private final UpdateCastlePort updateCastlePort;


    private final CreateCastleResourceUseCase createCastleResourceUseCase;
    private final CreateCastleStructureUseCase createCastleStructureUseCase;


    private final CastleFactory castleFactory;

    @Override
    public Castle create(CreateCastleCommand command) {
        Castle castle = castleFactory.createCastle(command.getName());
        castle = createCastlePort.create(castle);
        CastleResource castleResource = createCastleResourceUseCase.create(new CreateCastleResourceCommand(castle.getId()));
        castle.setCastleResource(castleResource);

        CastleStructure castleStructure = createCastleStructureUseCase.create(new CreateCastleStructureCommand(castle.getId()));
        castle.setCastleStructure(castleStructure);

        return updateCastlePort.update(castle.getId(), castle);
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
