package pl.dawid.main.structureBlueprint.application.port.out;

import pl.dawid.main.structureBlueprint.domain.StructureBlueprint;
import pl.dawid.main.structureBlueprint.domain.enums.StructureType;

public interface FetchByStructureTypePort {
    StructureBlueprint fetchByStructureType(StructureType structureType);
}
