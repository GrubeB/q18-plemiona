package pl.dawid.main.structure.application.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.dawid.main.aaShare.core.application.service.FetchByIdService;
import pl.dawid.main.structure.CastleStructure;
import pl.dawid.main.structure.application.port.in.FetchCastleStructureByIdUseCase;
import pl.dawid.main.structure.application.port.in.FetchStructureByStructureTypeUseCase;
import pl.dawid.main.structure.application.port.out.FetchCastleStructureByIdPort;
import pl.dawid.main.structure.domain.Structure;
import pl.dawid.main.structure_blueprint.domain.StructureType;

import java.util.Optional;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class FetchStructureByStructureTypeService implements
        FetchStructureByStructureTypeUseCase {
    private final FetchCastleStructureByIdPort fetchByIdPort;

    @Override
    public Structure fetchStructureByStructureType(Long castleStructureId, StructureType structureType) {
        CastleStructure castleStructure = fetchByIdPort.fetchById(castleStructureId);
        return Optional.ofNullable(castleStructure.getStructureObjectByStructureType(structureType))
                .orElseThrow(() -> new RuntimeException("Not found object with structureType: " + structureType));
    }
}
