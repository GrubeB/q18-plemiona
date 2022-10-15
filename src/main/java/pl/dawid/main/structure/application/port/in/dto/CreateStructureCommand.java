package pl.dawid.main.structure.application.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.dawid.main.aaShare.SelfValidating;
import pl.dawid.main.resource.application.port.in.dto.CreateCastleResourceCommand;
import pl.dawid.main.structure_blueprint.domain.StructureType;

@Getter
@AllArgsConstructor
public class CreateStructureCommand extends SelfValidating<CreateCastleResourceCommand> {
    private Long castleStructureId;
    private StructureType structureType;
}
