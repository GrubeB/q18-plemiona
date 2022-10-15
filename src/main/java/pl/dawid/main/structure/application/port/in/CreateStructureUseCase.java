package pl.dawid.main.structure.application.port.in;

import pl.dawid.main.aaShare.core.application.port.in.CreateUseCase;
import pl.dawid.main.structure.application.port.in.dto.CreateStructureCommand;
import pl.dawid.main.structure.domain.Structure;

public interface CreateStructureUseCase extends CreateUseCase<Structure, CreateStructureCommand> {
}
