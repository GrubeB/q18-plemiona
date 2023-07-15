package pl.dawid.main.structure.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.main.structure.CastleStructure;
import pl.dawid.main.structure_blueprint.domain.StructureBlueprint;
import pl.dawid.main.structure_blueprint.domain.StructureLevelType;
import pl.dawid.main.structure_blueprint.domain.StructureType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Structure {
    private Long id;
    private StructureLevelType level;
    @JsonIgnore
    private CastleStructure castleStructure;
    private StructureType structureType;

    public void setNextLevel() {
        level = level.getNextLevel();
    }
}
