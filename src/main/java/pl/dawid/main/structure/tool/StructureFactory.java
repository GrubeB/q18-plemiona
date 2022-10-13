package pl.dawid.main.structure.tool;

import lombok.Getter;
import lombok.Setter;
import pl.dawid.main.structureBlueprint.adapter.in.IronMine;
import pl.dawid.main.structureBlueprint.domain.StructureBlueprint;
import pl.dawid.main.structureBlueprint.domain.enums.StructureType;

@Getter
@Setter
public class StructureFactory {
    //@Autowired
    private static final IronMine ironMine=new IronMine();


    public static StructureBlueprint getStructureBlueprintByStructureType(StructureType structureType){
        switch (structureType){
            case IRON_MINE:
                return ironMine;
            case FARM:
                return ironMine;
            default:
                throw new RuntimeException("Nie ma takiego budynku!");
        }
    }
}
