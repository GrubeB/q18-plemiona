package pl.dawid.main.structureBlueprint.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dawid.main.structureBlueprint.application.port.out.FetchByStructureTypePort;
import pl.dawid.main.structureBlueprint.domain.StructureBlueprint;
import pl.dawid.main.structureBlueprint.domain.enums.StructureType;

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
