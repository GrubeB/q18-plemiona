package pl.dawid.main.structureBlueprint.application.port.out;

import pl.dawid.main.structureBlueprint.domain.StructureBlueprint;

public interface CreatePort {
    StructureBlueprint create(StructureBlueprint jpaEntity);
}
