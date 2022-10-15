package pl.dawid.main.structure_builder.application.port.out;

import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.structure_builder.domain.StructureBuild;

public interface UpdateStructureBuildPort {
    StructureBuild update(Long id, StructureBuild jpaEntity);
}
