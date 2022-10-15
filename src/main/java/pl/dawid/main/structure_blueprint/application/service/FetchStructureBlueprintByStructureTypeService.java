package pl.dawid.main.structure_blueprint.application.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.dawid.main.structure_blueprint.application.port.in.FetchByStructureTypeUseCase;
import pl.dawid.main.structure_blueprint.application.port.out.FetchStructureBlueprintByStructureTypePort;
import pl.dawid.main.structure_blueprint.domain.StructureBlueprint;
import pl.dawid.main.structure_blueprint.domain.StructureType;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class FetchStructureBlueprintByStructureTypeService implements
        FetchByStructureTypeUseCase {
    private final FetchStructureBlueprintByStructureTypePort fetchStructureBlueprintByStructureTypePort;
    @Override
    public StructureBlueprint fetchByStructureType(StructureType structureType) {
        return fetchStructureBlueprintByStructureTypePort.fetchByStructureType(structureType);
    }
}
