package pl.dawid.main.structure_blueprint.application.port.out;

import pl.dawid.main.structure_blueprint.domain.StructureBlueprint;

public interface FetchStructureBlueprintByIdPort {
    StructureBlueprint fetchById(Long id);
}
