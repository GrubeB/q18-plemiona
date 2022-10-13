package pl.dawid.main.structureBlueprint.adapter.in;

import lombok.Getter;
import lombok.Setter;
import pl.dawid.main.resource.domain.BaseResource;
import pl.dawid.main.resource.domain.ResourceType;
import pl.dawid.main.structure.StructureLevel;
import pl.dawid.main.structureBlueprint.domain.StructureBlueprint;
import pl.dawid.main.structureBlueprint.domain.enums.StructureLevelType;
import pl.dawid.main.structureBlueprint.domain.enums.StructureType;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class IronMine extends StructureBlueprint {

    public IronMine() {
        super(null,"iron mine","description",3, StructureType.IRON_MINE,new HashMap<>());
        init();
    }

    private void init() {
        StructureLevel structureLevel1=new StructureLevel(null,
                StructureLevelType.LEVEL1,
                Duration.ofSeconds(10),
                List.of(new BaseResource(100L, ResourceType.IRON),
                        new BaseResource(100L, ResourceType.CLAY),
                        new BaseResource(100L, ResourceType.WOOD),
                        new BaseResource(0L, ResourceType.EMPLOYEE)
                        ),new ArrayList<>(),new ArrayList<>(),this);

        StructureLevel structureLevel2=new StructureLevel(null,
                StructureLevelType.LEVEL2,
                Duration.ofSeconds(15),
                List.of(new BaseResource(200L, ResourceType.IRON),
                        new BaseResource(200L, ResourceType.CLAY),
                        new BaseResource(200L, ResourceType.WOOD),
                        new BaseResource(0L, ResourceType.EMPLOYEE)
                ),new ArrayList<>(),new ArrayList<>(),this);

        StructureLevel structureLevel3=new StructureLevel(null,
                StructureLevelType.LEVEL3,
                Duration.ofSeconds(20),
                List.of(new BaseResource(300L, ResourceType.IRON),
                        new BaseResource(300L, ResourceType.CLAY),
                        new BaseResource(300L, ResourceType.WOOD),
                        new BaseResource(0L, ResourceType.EMPLOYEE)
                ),new ArrayList<>(),new ArrayList<>(),this);
        structureLevelMap.put(StructureLevelType.LEVEL1,structureLevel1);
        structureLevelMap.put(StructureLevelType.LEVEL2,structureLevel2);
        structureLevelMap.put(StructureLevelType.LEVEL3,structureLevel2);
    }

}
