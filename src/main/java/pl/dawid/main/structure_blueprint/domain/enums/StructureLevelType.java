package pl.dawid.main.structure_blueprint.domain.enums;

import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
public enum StructureLevelType {
    LEVEL0(0),
    LEVEL1(1),
    LEVEL2(2),
    LEVEL3(3);

    public Integer level;

    StructureLevelType(Integer level) {
        this.level = level;
    }

    public static StructureLevelType getNextLevel(StructureLevelType levelType) {
        Integer currentLevel = levelType.getLevel();
        return StructureLevelType.byLevel(currentLevel+1);
    }
    public StructureLevelType getNextLevel() {
        return getNextLevel(StructureLevelType.byLevel(level));
    }

    private static final Map<Integer, StructureLevelType> BY_CODE_MAP = new LinkedHashMap<>();

    static {
        for (StructureLevelType levelType : StructureLevelType.values()) {
            BY_CODE_MAP.put(levelType.level, levelType);
        }
    }

    public static StructureLevelType byLevel(Integer level) {
        StructureLevelType levelType = BY_CODE_MAP.get(level);
        if(levelType==null){
            throw new RuntimeException("Nie ma więcej leveli, SADGE");
        }
        return levelType;
    }
}