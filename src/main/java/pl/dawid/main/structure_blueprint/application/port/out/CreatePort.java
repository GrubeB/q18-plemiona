package pl.dawid.main.structure_blueprint.application.port.out;

import pl.dawid.main.structure_blueprint.domain.StructureBlueprint;

public interface CreatePort {
    StructureBlueprint create(StructureBlueprint jpaEntity);
}
