package pl.dawid.main.castle.application.service;

import lombok.RequiredArgsConstructor;
import pl.dawid.main.aaShare.NotFoundException;
import pl.dawid.main.castle.application.CastleValidator;
import pl.dawid.main.castle.application.port.in.AddResourceToCastleCommand;
import pl.dawid.main.castle.application.port.in.AddResourceToCastleUseCase;
import pl.dawid.main.castle.application.port.in.CreateCastleCommand;
import pl.dawid.main.castle.application.port.in.CreateCastleUseCase;
import pl.dawid.main.castle.application.port.out.CreateCastlePort;
import pl.dawid.main.castle.application.port.out.FetchCastlePort;
import pl.dawid.main.castle.application.port.out.UpdateCastleResourcePort;
import pl.dawid.main.castle.domain.Castle;

import java.util.Optional;

@RequiredArgsConstructor
public class AddResourceToCastleService implements AddResourceToCastleUseCase {

    private final UpdateCastleResourcePort updateCastleResourcePort;
    private final FetchCastlePort fetchCastlePort;
    private final CastleValidator castleValidator;

    @Override
    public void addResourceToCastle(Long castleId, AddResourceToCastleCommand command){
        // TODO Validation
        Castle castle = fetchCastlePort.findById(castleId).orElseThrow(() -> new NotFoundException(castleId));
        castle.getCastleResourceList().forEach(castleResource ->
            command.getResourceList().stream()
                    .filter(resource -> resource.getType().equals(castleResource.getType()))
                    .findFirst().ifPresent(resource -> {
                        castleResource.addResource(resource.getAmount());
                        updateCastleResourcePort.updateEntity(castleResource);
                    })
        );

    }
}
