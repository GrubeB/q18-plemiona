package pl.dawid.main.structure.application.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.dawid.main.aaShare.SelfValidating;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.resource.application.port.in.dto.CreateCastleResourceCommand;

@Getter
@AllArgsConstructor
public class CreateCastleStructureCommand extends SelfValidating<CreateCastleResourceCommand> {
    private Castle castle;
}
