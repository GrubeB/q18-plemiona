package pl.dawid.main.structure.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.main.structure.CastleStructure;
import pl.dawid.main.structure_blueprint.domain.StructureBlueprint;
import pl.dawid.main.structure_blueprint.domain.StructureLevelType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Structure {
    private Long id;
    private StructureLevelType level;
    private CastleStructure castleStructure;
    private StructureBlueprint structureBlueprint;

    public void setNextLevel() {
        level = level.getNextLevel();
    }
}
