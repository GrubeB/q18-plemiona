package pl.dawid.main.structureBlueprint.application.port.out;

import pl.dawid.main.structureBlueprint.domain.StructureBlueprint;

import java.util.List;

public interface FetchAllPort {
    List<StructureBlueprint> fetchAll();
}
