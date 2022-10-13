package pl.dawid.main.structure.application.port.out;

import pl.dawid.main.structure.CastleStructure;

public interface CreateCastleStructurePort {
    CastleStructure create(CastleStructure jpaEntity);
}
