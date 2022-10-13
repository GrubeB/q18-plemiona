package pl.dawid.main.structure.application.port.out;

import pl.dawid.main.structure.CastleStructure;

public interface UpdateCastleStructurePort {
    CastleStructure update(Long id, CastleStructure jpaEntity);
}
