package pl.dawid.main.structure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.main.resource.domain.BaseResource;
import pl.dawid.main.structure_blueprint.domain.StructureRequirement;
import pl.dawid.main.structure_blueprint.domain.StructureProperty;
import pl.dawid.main.structure_blueprint.domain.enums.StructureLevelType;
import pl.dawid.main.structure_blueprint.domain.StructureBlueprint;

import java.time.Duration;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StructureLevel {

    private Long id;
    private StructureLevelType level;
    private Duration duration;

    private List<BaseResource> resourceList;
    private List<StructureProperty> structurePropertyList;
    private List<StructureRequirement> structureRequirementList;

    private StructureBlueprint structureBlueprint;
}