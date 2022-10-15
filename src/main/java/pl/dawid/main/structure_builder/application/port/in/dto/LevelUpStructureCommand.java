package pl.dawid.main.structure_builder.application.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.dawid.main.aaShare.SelfValidating;
import pl.dawid.main.resource.application.port.in.dto.CreateCastleResourceCommand;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LevelUpStructureCommand extends SelfValidating<CreateCastleResourceCommand> {
    private Long castleStructureId;
    private Long castleResourceId;
    private Long structureId;
}