package pl.dawid.main.structure.application.port.in;

import pl.dawid.main.structure.CastleStructure;
import pl.dawid.main.structure.application.port.in.dto.CreateCastleStructureCommand;

public interface CreateCastleStructurePort {
    CastleStructure createCastleStructure(CreateCastleStructureCommand command);
}
