package pl.dawid.main.structure.application.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dawid.main.castle.application.port.in.FetchCastleByIdUseCase;
import pl.dawid.main.structure.CastleStructure;
import pl.dawid.main.structure.application.CastleStructureFactory;
import pl.dawid.main.structure.application.port.in.CreateStructureUseCase;
import pl.dawid.main.structure.application.port.in.dto.CreateStructureCommand;
import pl.dawid.main.structure.application.port.out.CreateCastleStructurePort;
import pl.dawid.main.structure.application.port.out.structure.CreateStructurePort;
import pl.dawid.main.structure.application.port.out.FetchCastleStructureByIdPort;
import pl.dawid.main.structure.application.port.out.UpdateCastleStructurePort;
import pl.dawid.main.structure.domain.Structure;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class CreateStructureService implements
        CreateStructureUseCase {
    private final FetchCastleStructureByIdPort fetchCastleStructureByIdPort;
    private final UpdateCastleStructurePort updateCastleStructurePort;
    //private final CreateStructurePort createStructurePort;

    private final CastleStructureFactory castleStructureFactory;

    @Override
    public Structure create(CreateStructureCommand command) {
        CastleStructure castleStructure = fetchCastleStructureByIdPort.fetchById(command.getCastleStructureId());
        Structure structureFromFactory = castleStructureFactory.createStructure(command.getStructureType(), castleStructure);
        //Structure savedStructure = createStructurePort.createStructure(structureFromFactory);
        castleStructure.addStructureObject(structureFromFactory);
        updateCastleStructurePort.update(castleStructure.getId(),castleStructure);
        return structureFromFactory;
    }
}
