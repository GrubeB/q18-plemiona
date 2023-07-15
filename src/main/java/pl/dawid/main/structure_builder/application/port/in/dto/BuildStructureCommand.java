package pl.dawid.main.structure_builder.application.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.main.aaShare.SelfValidating;
import pl.dawid.main.resource.application.port.in.dto.CreateCastleResourceCommand;
import pl.dawid.main.structure_blueprint.domain.StructureType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuildStructureCommand extends SelfValidating<CreateCastleResourceCommand>
{
    private Long castleStructureId;
    private Long castleResourceId;
    private StructureType structureType;
}