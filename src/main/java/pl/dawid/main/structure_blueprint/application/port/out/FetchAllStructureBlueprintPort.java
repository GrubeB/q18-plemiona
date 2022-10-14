package pl.dawid.main.structure_blueprint.application.port.out;

import pl.dawid.main.structure_blueprint.domain.StructureBlueprint;

import java.util.List;

public interface FetchAllStructureBlueprintPort {
    List<StructureBlueprint> fetchAll();
}
