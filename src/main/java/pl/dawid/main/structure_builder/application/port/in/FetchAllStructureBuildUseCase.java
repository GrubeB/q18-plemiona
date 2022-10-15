package pl.dawid.main.structure_builder.application.port.in;

import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.structure_builder.domain.StructureBuild;

import java.util.List;

public interface FetchAllStructureBuildUseCase {
    List<StructureBuild> fetchAll();
}
