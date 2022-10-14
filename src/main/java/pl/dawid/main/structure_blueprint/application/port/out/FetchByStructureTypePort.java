package pl.dawid.main.structure_blueprint.application.port.out;

import pl.dawid.main.structure_blueprint.domain.StructureBlueprint;
import pl.dawid.main.structure_blueprint.domain.enums.StructureType;

public interface FetchByStructureTypePort {
    StructureBlueprint fetchByStructureType(StructureType structureType);
}
