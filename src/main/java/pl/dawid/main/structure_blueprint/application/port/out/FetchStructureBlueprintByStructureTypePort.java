package pl.dawid.main.structure_blueprint.application.port.out;

import pl.dawid.main.structure_blueprint.domain.StructureBlueprint;
import pl.dawid.main.structure_blueprint.domain.StructureType;

public interface FetchStructureBlueprintByStructureTypePort {
    StructureBlueprint fetchByStructureType(StructureType structureType);
}
