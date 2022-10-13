package pl.dawid.main.structure.application.port.out;

import pl.dawid.main.structure.CastleStructure;

import java.util.List;

public interface FetchAllCastleStructurePort {
    List<CastleStructure> fetchAll();
}
