package pl.dawid.main.structure_builder.application.port.in;

import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.structure_builder.domain.StructureBuild;

public interface FetchStructureBuildByIdUseCase {
    StructureBuild fetchById(Long id);

}
