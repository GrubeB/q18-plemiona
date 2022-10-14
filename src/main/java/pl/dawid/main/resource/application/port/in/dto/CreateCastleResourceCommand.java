package pl.dawid.main.resource.application.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.dawid.main.aaShare.SelfValidating;
import pl.dawid.main.castle.domain.Castle;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCastleResourceCommand extends SelfValidating<CreateCastleResourceCommand> {
    private Long castleId;
}
