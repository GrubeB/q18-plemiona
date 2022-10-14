package pl.dawid.main.structure.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dawid.main.castle.application.port.in.FetchCastleByIdUseCase;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.resource.domain.CastleResource;
import pl.dawid.main.structure.CastleStructure;
import pl.dawid.main.structure.application.port.in.CreateCastleStructureUseCase;
import pl.dawid.main.structure.application.port.in.FetchCastleStructureUseCase;
import pl.dawid.main.structure.application.port.in.dto.CreateCastleStructureCommand;
import pl.dawid.main.structure.application.port.out.CreateCastleStructurePort;
import pl.dawid.main.structure.application.port.out.FetchByIdCastleStructurePort;

@Service
@RequiredArgsConstructor
public class CastleStructureService implements
        CreateCastleStructureUseCase,
        FetchCastleStructureUseCase {

    private final CreateCastleStructurePort createCastleStructurePort;
    private final FetchByIdCastleStructurePort fetchByIdCastleStructurePort;


    private final FetchCastleByIdUseCase fetchCastleByIdUseCase;


    private final CastleStructureFactory castleStructureFactory;
    @Override
    public CastleStructure create(CreateCastleStructureCommand command) {
        Castle castle = fetchCastleByIdUseCase.fetchById(command.getCastleId());
        CastleStructure castleStructureFromFactory = castleStructureFactory.createCastleStructure(castle);
        castle.setCastleStructure(castleStructureFromFactory);
        castleStructureFromFactory.setCastle(castle);
        return createCastleStructurePort.create(castleStructureFromFactory);
    }

    @Override
    public CastleStructure fetchById(Long id) {
        return fetchByIdCastleStructurePort.fetchById(id);
    }
}
