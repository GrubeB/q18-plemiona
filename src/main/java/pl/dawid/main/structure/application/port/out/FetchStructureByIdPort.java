package pl.dawid.main.structure.application.port.out;

import pl.dawid.main.structure.domain.Structure;

public interface FetchStructureByIdPort {
    Structure fetchStructureById(Long id);
}
