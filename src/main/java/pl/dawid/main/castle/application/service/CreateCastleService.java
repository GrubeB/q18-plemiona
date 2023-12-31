package pl.dawid.main.castle.application.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dawid.main.castle.application.CastleFactory;
import pl.dawid.main.castle.application.port.in.CreateCastleCommand;
import pl.dawid.main.castle.application.port.in.CreateCastleUseCase;
import pl.dawid.main.castle.application.port.out.CreateCastlePort;
import pl.dawid.main.castle.application.port.out.UpdateCastlePort;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.resource.application.port.in.CreateCastleResourceUseCase;
import pl.dawid.main.resource.application.port.in.dto.CreateCastleResourceCommand;
import pl.dawid.main.resource.domain.CastleResource;
import pl.dawid.main.structure.CastleStructure;
import pl.dawid.main.structure.application.port.in.CreateCastleStructureUseCase;
import pl.dawid.main.structure.application.port.in.dto.CreateCastleStructureCommand;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class CreateCastleService implements CreateCastleUseCase{

    private final CreateCastlePort createCastlePort;
    private final UpdateCastlePort updateCastlePort;

    @Autowired
    private CreateCastleResourceUseCase createCastleResourceUseCase;
    @Autowired
    private CreateCastleStructureUseCase createCastleStructureUseCase;


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


}
