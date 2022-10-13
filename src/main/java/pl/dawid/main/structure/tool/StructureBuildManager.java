package pl.dawid.main.structure.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.dawid.main.structure.domain.Structure;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class StructureBuildManager {
    private Map<Long,StructureBuild> structureBuildMap; //StructureId,StructureBuild
    private static final Logger logger = LoggerFactory.getLogger(StructureBuildManager.class);

    public StructureBuildManager() {
        structureBuildMap=new HashMap<>();
    }

    public void structureBuildManagerAutoUpdate() {
        logger.info("structureBuildManagerAutoUpdate");
        List<Map.Entry<Long, StructureBuild>> collect = structureBuildMap
                .entrySet()
                .stream()
                .filter(e -> e.getValue().getEndDataTime().isBefore(LocalDateTime.now()))
                .collect(Collectors.toUnmodifiableList());
        collect.forEach(e->{
            logger.info("Budynek zbudowany");
            e.getValue().getStructure().setNextLevel();
            structureBuildMap.remove(e.getKey());
        });

    }
    public void checkIfStructureIsBuilding(Structure structure) {
        if(structureBuildMap.containsKey(structure.getId())){
            throw new RuntimeException("Budynek jest aktualnie w budowie");
        }
    }
    public void addStructureBuild(StructureBuild structureBuild){
        if(Objects.isNull(structureBuildMap.get(structureBuild.getId()))){
            structureBuildMap.put(structureBuild.getStructure().getId(),structureBuild);
            logger.info("Budynek dodano do kolejki");
        }
    }
    public void removeStructureBuild(StructureBuild structureBuild){
        structureBuildMap.remove(structureBuild.getStructure().getId());
    }
    public  Map<Long,StructureBuild> getStructureBuildMap(){
        return Collections.unmodifiableMap(this.structureBuildMap);
    }


}
