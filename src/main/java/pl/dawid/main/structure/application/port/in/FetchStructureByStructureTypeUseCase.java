package pl.dawid.main.structure.application.port.in;


import pl.dawid.main.aaShare.core.application.port.in.FetchByIdUseCase;
import pl.dawid.main.structure.domain.Structure;
import pl.dawid.main.structure_blueprint.domain.StructureType;

public interface FetchStructureByStructureTypeUseCase{
    Structure fetchStructureByStructureType(Long castleStructureId, StructureType structureType);
}
