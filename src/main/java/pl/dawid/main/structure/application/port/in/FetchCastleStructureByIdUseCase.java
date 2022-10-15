package pl.dawid.main.structure.application.port.in;


import pl.dawid.main.structure.CastleStructure;

public interface FetchCastleStructureByIdUseCase {
    CastleStructure fetchById(Long id);
}
