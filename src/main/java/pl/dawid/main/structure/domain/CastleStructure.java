package pl.dawid.main.structure;

import lombok.*;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.resource.domain.CastleResource;
import pl.dawid.main.structure.domain.Structure;
import pl.dawid.main.structureBlueprint.domain.enums.StructureType;
import pl.dawid.main.structure.tool.StructureBuildManager;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CastleStructure {

    private Long id;

    private Castle castle;
    private Map<StructureType, Structure> structureMap;
    //private Map<StructureType, Structure> structureBuildingMap;
    private static Long nextID=1L;

    /* METHODS */
    public void levelUpStructure(StructureType structureType, CastleResource castleResource, StructureBuildManager structureBuildManager) throws IllegalStateException {
//        if(structureType==null) {
//            throw new IllegalStateException("StructureType Is Null");
//        }
//        if(!getIfStructureExists(structureType)){
//            StructureBlueprint  structureBlueprint = StructureFactory.getStructureBlueprintByStructureType(structureType);
//            Structure structure = new Structure(nextID, StructureLevelType.LEVEL0, this, structureBlueprint);
//            nextID++;
//            structureMap.put(structureType,structure);
//        }
//
//        Structure structure = structureMap.get(structureType);
//        StructureLevel nextStructureLevel= structure.getStructureBlueprint().getNextStructureLevel(structure.getLevel());
//
//        // ================================SKPRAWDZENIE===================================
//        // pusta kolejka budowy
//
//        // sprawdzenie czy nie jest budowany
//        structureBuildManager.checkIfStructureIsBuilding(structure);
//        // spełnie ilosci surowców
//        List<BaseResource> resourceList = nextStructureLevel.getResourceList();
//        castleResource.verifyIfIsEnoughResourceList(resourceList);
//        // spełnia wymagania
//
//
//
//        // ================================BUDOWANIE===================================
//        // odjęcie surowców
//        castleResource.subtractResourceList(resourceList);
//        // dodanie do kolejki but right now just level up
////            StructureLevelType nextLevel = structureMap.get(structureType).getLevel().getNextLevel();
////            structureMap.get(structureType).setLevel(nextLevel);
//        StructureBuild structureBuild = new StructureBuild(
//                nextID,
//                structure,
//                LocalDateTime.now(),
//                LocalDateTime.now().plusSeconds(nextStructureLevel.getDuration().getSeconds()));
//        nextID++;
//        structureBuildManager.addStructureBuild(structureBuild);

    }


    public boolean getIfStructureExists(StructureType structureType){
        return structureMap.containsKey(structureType);
    }
    @Override
    public String toString() {
        String log = structureMap.entrySet().stream()
                .map((e)->"["+e.getKey()+" "+e.getValue().getLevel()+"]")
                .reduce(" ",(v1,v2)->v1 + " "+v2);
        return "CastleStructure{" +log +'}';
    }

}
