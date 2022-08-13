package pl.dawid.main.castle.application;

import lombok.RequiredArgsConstructor;
import pl.dawid.main.castle.application.port.in.CreateCastleCommand;
import pl.dawid.main.castle.application.port.in.CreateCastleUseCase;
import pl.dawid.main.castle.application.port.out.CreateCastlePort;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.castle.domain.CastleResource;

@RequiredArgsConstructor
public class CreateCastleService implements CreateCastleUseCase {

    private final CreateCastlePort createCastlePort;

    @Override
    public Castle createCastle(CreateCastleCommand command) {
        // 1. Validate state
        // 2. Create object
        Castle newCastle = new Castle(null, command.getName());
        CastleResource wood = new CastleResource(0L, 1000L,newCastle, CastleResource.ResourceType.WOOD);
        CastleResource clay = new CastleResource(0L, 1000L,newCastle, CastleResource.ResourceType.CLAY);
        CastleResource iron = new CastleResource(0L, 1000L,newCastle, CastleResource.ResourceType.IRON);
        CastleResource employee = new CastleResource(0L, 1000L,newCastle, CastleResource.ResourceType.EMPLOYEE);

        newCastle.addCastleResource(wood);
        newCastle.addCastleResource(clay);
        newCastle.addCastleResource(iron);
        newCastle.addCastleResource(employee);
        // 3. Save
        createCastlePort.createEntity(newCastle);
        return newCastle;
    }
}
