package pl.dawid.main.structure.application.port.out;

import pl.dawid.main.structure.CastleStructure;

public interface FetchByIdCastleStructurePort {
    CastleStructure fetchById(Long id);
}
