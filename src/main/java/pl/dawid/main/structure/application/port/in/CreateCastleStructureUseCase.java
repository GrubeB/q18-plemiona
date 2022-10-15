package pl.dawid.main.structure.application.port.in;

import pl.dawid.main.aaShare.core.application.port.in.CreateUseCase;
import pl.dawid.main.structure.CastleStructure;
import pl.dawid.main.structure.application.port.in.dto.CreateCastleStructureCommand;

public interface CreateCastleStructureUseCase extends CreateUseCase<CastleStructure,CreateCastleStructureCommand> {
}
