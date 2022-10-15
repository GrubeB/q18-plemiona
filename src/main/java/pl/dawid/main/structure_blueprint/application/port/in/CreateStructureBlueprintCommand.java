package pl.dawid.main.structure_blueprint.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.dawid.main.structure_blueprint.domain.StructureBlueprint;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateStructureBlueprintCommand {
    private StructureBlueprint structureBlueprint;
}
