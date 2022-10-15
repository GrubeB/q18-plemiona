package pl.dawid.main.structure.application.port.out;

import pl.dawid.main.structure.CastleStructure;

public interface FetchCastleStructureByIdPort {
    CastleStructure fetchById(Long id);
}
