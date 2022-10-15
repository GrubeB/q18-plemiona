package pl.dawid.main.structure_blueprint.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.main.aaShare.core.domain.SetId;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StructureBlueprint implements SetId {
    @Setter
    protected Long id;
    protected String name;
    protected String description;
    protected Integer levelMax;
    protected StructureType structureType;
    protected Map<StructureLevelType, StructureLevel> structureLevelMap;


    public void addStructureLevel(StructureLevel structureLevel) {
        if (Objects.isNull(structureLevelMap.get(structureLevel.getLevel()))) {
            structureLevelMap.put(structureLevel.getLevel(), structureLevel);
        }
    }

    public void removeResourceLevel(StructureLevel structureLevel) {
        structureLevelMap.remove(structureLevel.getLevel());
    }

    public Map<StructureLevelType, StructureLevel> getStructureLevelList() {
        return Collections.unmodifiableMap(this.structureLevelMap);
    }

    // ---------------------------------------------------------------------------------------------------------------
    public StructureLevel getNextStructureLevel(StructureLevelType level) {
        if (level.level >= levelMax) {
            throw new IllegalStateException("you have reached the maximum level");
        }
        StructureLevelType nextLevel = StructureLevelType.getNextLevel(level);
        return structureLevelMap.get(nextLevel);
    }

    public StructureLevel getFirstStructureLevel() {
        if (StructureLevelType.LEVEL1.getLevel() >= levelMax) {
            throw new IllegalStateException("there is not first level of structure");
        }
        return structureLevelMap.get(StructureLevelType.LEVEL1);
    }
}
