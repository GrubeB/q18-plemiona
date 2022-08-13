package pl.dawid.main.castle.application;

import lombok.RequiredArgsConstructor;
import pl.dawid.main.castle.application.port.in.CreateCastleCommand;
import pl.dawid.main.castle.application.port.in.CreateCastleUseCase;
import pl.dawid.main.castle.application.port.out.CreateCastlePort;
import pl.dawid.main.castle.domain.Castle;

@RequiredArgsConstructor
public class CreateCastleService implements CreateCastleUseCase {

    private final CreateCastlePort createCastlePort;
    private final CastleFactory castleFactory;
    private final CastleValidator castleValidator;


    @Override
    public Castle createCastle(CreateCastleCommand command) {
        castleValidator.validateUniqueName(command.getName());
        Castle newCastle = castleFactory.createBaseCastle();
        newCastle.setName(command.getName());
        return createCastlePort.createEntity(newCastle);
    }
}
