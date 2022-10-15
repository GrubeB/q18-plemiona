package pl.dawid.main.structure.application.port.in;


import pl.dawid.main.structure.domain.Structure;

public interface FetchStructureByIdUseCase {
    Structure fetchStructureById(Long id);
}
