package pl.dawid.main.structure.application.port.in;


import pl.dawid.main.structure.CastleStructure;

public interface FetchCastleStructurePort {
    CastleStructure fetchById(Long id);
}
