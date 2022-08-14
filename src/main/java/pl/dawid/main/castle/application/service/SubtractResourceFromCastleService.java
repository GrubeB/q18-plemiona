package pl.dawid.main.castle.application.service;

import lombok.RequiredArgsConstructor;
import pl.dawid.main.aaShare.NotFoundException;
import pl.dawid.main.castle.application.CastleValidator;
import pl.dawid.main.castle.application.port.in.AddResourceToCastleCommand;
import pl.dawid.main.castle.application.port.in.AddResourceToCastleUseCase;
import pl.dawid.main.castle.application.port.in.SubtractResourceFromCastleCommand;
import pl.dawid.main.castle.application.port.in.SubtractResourceFromCastleUseCase;
import pl.dawid.main.castle.application.port.out.FetchCastlePort;
import pl.dawid.main.castle.application.port.out.UpdateCastleResourcePort;
import pl.dawid.main.castle.domain.Castle;

import javax.transaction.Transactional;

@RequiredArgsConstructor
public class SubtractResourceFromCastleService implements SubtractResourceFromCastleUseCase {

    private final UpdateCastleResourcePort updateCastleResourcePort;
    private final FetchCastlePort fetchCastlePort;
    private final CastleValidator castleValidator;

    @Override
    @Transactional
    public void subtractResourceFromCastle(Long castleId, SubtractResourceFromCastleCommand command) {
        // TODO Validation
        Castle castle = fetchCastlePort.findById(castleId).orElseThrow(() -> new NotFoundException(castleId));
        castle.getCastleResourceList().forEach(castleResource ->
                command.getResourceList().stream()
                        .filter(resource -> resource.getType().equals(castleResource.getType()))
                        .findFirst().ifPresent(resource -> {
                            castleResource.subtractResource(resource.getAmount());
                            updateCastleResourcePort.updateEntity(castleResource);
                        })
        );
    }

}
