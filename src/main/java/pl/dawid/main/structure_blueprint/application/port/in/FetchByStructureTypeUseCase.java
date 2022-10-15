package pl.dawid.main.structure_blueprint.application.port.in;

import pl.dawid.main.aaShare.core.application.port.in.FetchByIdUseCase;
import pl.dawid.main.structure_blueprint.domain.StructureBlueprint;
import pl.dawid.main.structure_blueprint.domain.StructureType;

public interface FetchByStructureTypeUseCase {
    StructureBlueprint fetchByStructureType(StructureType structureType);
}
