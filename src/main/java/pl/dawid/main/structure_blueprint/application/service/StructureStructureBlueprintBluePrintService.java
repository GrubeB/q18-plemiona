package pl.dawid.main.structure_blueprint.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dawid.main.structure_blueprint.application.port.out.FetchStructureBlueprintByStructureTypePort;
import pl.dawid.main.structure_blueprint.domain.StructureBlueprint;
import pl.dawid.main.structure_blueprint.domain.StructureType;

@Service
@RequiredArgsConstructor
public class StructureStructureBlueprintBluePrintService implements
        FetchStructureBlueprintByStructureTypePort {

    private final FetchStructureBlueprintByStructureTypePort fetchStructureBlueprintByStructureTypePort;
    @Override
    public StructureBlueprint fetchByStructureType(StructureType structureType) {
        return fetchStructureBlueprintByStructureTypePort.fetchByStructureType(structureType);
    }
}
