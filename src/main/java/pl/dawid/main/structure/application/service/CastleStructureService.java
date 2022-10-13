package pl.dawid.main.structure.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dawid.main.structure.CastleStructure;
import pl.dawid.main.structure.application.port.in.FetchCastleStructurePort;
import pl.dawid.main.structure.application.port.in.dto.CreateCastleStructureCommand;
import pl.dawid.main.structure.application.port.out.CreateCastleStructurePort;
import pl.dawid.main.structure.application.port.out.FetchByIdCastleStructurePort;

@Service
@RequiredArgsConstructor
public class CastleStructureService implements
        pl.dawid.main.structure.application.port.in.CreateCastleStructurePort,
        FetchCastleStructurePort {

    private final CreateCastleStructurePort createCastleStructurePort;
    private final FetchByIdCastleStructurePort fetchByIdCastleStructurePort;
    private final CastleStructureFactory castleStructureFactory;
    @Override
    public CastleStructure createCastleStructure(CreateCastleStructureCommand command) {
        CastleStructure castleStructureFromFactory = castleStructureFactory.createCastleStructure(command.getCastle());
        CastleStructure castleStructure = createCastleStructurePort.create(castleStructureFromFactory);
        return castleStructure;
    }

    @Override
    public CastleStructure fetchById(Long id) {
        return fetchByIdCastleStructurePort.fetchById(id);
    }
}
