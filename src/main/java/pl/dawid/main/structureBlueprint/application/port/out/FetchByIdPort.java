package pl.dawid.main.structureBlueprint.application.port.out;

import pl.dawid.main.structureBlueprint.domain.StructureBlueprint;

public interface FetchByIdPort {
    StructureBlueprint fetchById(Long id);
}
