package pl.dawid.main.resource.application.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.dawid.main.resource.application.port.in.SubtractResourceUseCase;
import pl.dawid.main.resource.application.port.in.dto.SubtractResourceCommand;
import pl.dawid.main.resource.application.port.out.FetchCastleResourceByIdPort;
import pl.dawid.main.resource.application.port.out.UpdateCastleResourcePort;
import pl.dawid.main.resource.domain.CastleResource;

@Service
@Setter
@RequiredArgsConstructor
public class SubtractResourceCastleResourceService implements
        SubtractResourceUseCase {
    private final UpdateCastleResourcePort updateCastleResourcePort;
    private final FetchCastleResourceByIdPort fetchCastleResourceByIdPort;

    @Override
    public void subtractResource(Long castleResourceId, SubtractResourceCommand command) {
        CastleResource castleResource = fetchCastleResourceByIdPort.fetchById(castleResourceId);
        castleResource.subtractResourceList(command.getResourceList());
        updateCastleResourcePort.update(castleResourceId, castleResource);
    }
}
