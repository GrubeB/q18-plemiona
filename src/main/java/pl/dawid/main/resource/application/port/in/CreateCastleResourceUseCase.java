package pl.dawid.main.resource.application.port.in;


import pl.dawid.main.aaShare.core.application.port.in.CreateUseCase;
import pl.dawid.main.resource.application.port.in.dto.CreateCastleResourceCommand;
import pl.dawid.main.resource.domain.CastleResource;
public interface CreateCastleResourceUseCase extends CreateUseCase<CastleResource,CreateCastleResourceCommand> {
}
