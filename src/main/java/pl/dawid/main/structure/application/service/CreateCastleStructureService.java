package pl.dawid.main.structure.application.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dawid.main.castle.application.port.in.FetchCastleByIdUseCase;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.structure.CastleStructure;
import pl.dawid.main.structure.application.CastleStructureFactory;
import pl.dawid.main.structure.application.port.in.CreateCastleStructureUseCase;
import pl.dawid.main.structure.application.port.in.dto.CreateCastleStructureCommand;
import pl.dawid.main.structure.application.port.out.CreateCastleStructurePort;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class CreateCastleStructureService implements
        CreateCastleStructureUseCase {
    private final CreateCastleStructurePort createCastleStructurePort;
    @Autowired
    private FetchCastleByIdUseCase fetchCastleByIdUseCase;

    private final CastleStructureFactory castleStructureFactory;
    @Override
    public CastleStructure create(CreateCastleStructureCommand command) {
        Castle castle = fetchCastleByIdUseCase.fetchById(command.getCastleId());
        CastleStructure castleStructureFromFactory = castleStructureFactory.createCastleStructure(castle);
        castle.setCastleStructure(castleStructureFromFactory);
        return createCastleStructurePort.create(castleStructureFromFactory);
    }
}
