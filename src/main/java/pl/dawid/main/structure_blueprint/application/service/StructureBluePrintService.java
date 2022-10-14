package pl.dawid.main.structure_blueprint.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dawid.main.structure_blueprint.application.port.out.FetchByStructureTypePort;
import pl.dawid.main.structure_blueprint.domain.StructureBlueprint;
import pl.dawid.main.structure_blueprint.domain.enums.StructureType;

@Service
@RequiredArgsConstructor
public class StructureBluePrintService implements
        FetchByStructureTypePort {

    private final FetchByStructureTypePort fetchByStructureTypePort;
    @Override
    public StructureBlueprint fetchByStructureType(StructureType structureType) {
        return fetchByStructureTypePort.fetchByStructureType(structureType);
    }
}
