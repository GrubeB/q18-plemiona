package pl.dawid.main.resource.application.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.dawid.main.aaShare.SelfValidating;
import pl.dawid.main.castle.domain.Castle;

@Getter
@AllArgsConstructor
public class CreateCastleResourceCommand extends SelfValidating<CreateCastleResourceCommand> {
    private Castle castle;
}
