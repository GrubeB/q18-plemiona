package pl.dawid.main.structureBlueprint.application.port.in;

import pl.dawid.main.structureBlueprint.domain.StructureBlueprint;
import pl.dawid.main.structureBlueprint.domain.enums.StructureType;

public interface FetchByStructureTypeUseCase {
    StructureBlueprint fetchByStructureType(StructureType structureType);
}
