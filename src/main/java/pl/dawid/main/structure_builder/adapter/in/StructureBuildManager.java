package pl.dawid.main.structure_builder.adapter.in;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.dawid.main.resource.adapter.in.CastleResourceAutoUpdateAdapter;
import pl.dawid.main.resource.application.port.in.FetchAllCastleResourceUseCase;
import pl.dawid.main.resource.domain.CastleResource;
import pl.dawid.main.structure.CastleStructure;
import pl.dawid.main.structure.application.port.out.FetchCastleStructureByIdPort;
import pl.dawid.main.structure.application.port.out.UpdateCastleStructurePort;
import pl.dawid.main.structure.domain.Structure;
import pl.dawid.main.structure_builder.application.port.in.FetchAllStructureBuildUseCase;
import pl.dawid.main.structure_builder.application.port.out.DeleteStructureBuildPort;
import pl.dawid.main.structure_builder.domain.StructureBuild;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StructureBuildManager {

    private static final Logger logger = LoggerFactory.getLogger(StructureBuildManager.class);

    private final FetchAllStructureBuildUseCase fetchAllStructureBuildUseCase;
    private final DeleteStructureBuildPort deleteStructureBuildPort;
    private final FetchCastleStructureByIdPort fetchCastleStructureByIdPort;
    private final UpdateCastleStructurePort updateCastleStructurePort;


    @Scheduled(initialDelay  = 100, fixedDelay = 1000)
    private void structureBuildManagerAutoUpdate() {
        logger.info("structureBuildManagerAutoUpdate");
        List<StructureBuild> collect = fetchAllStructureBuildUseCase.fetchAll().stream()
                .filter(e -> e.getEndDataTime().isBefore(LocalDateTime.now()))
                .collect(Collectors.toList());
        collect.forEach(structureBuild -> deleteStructureBuildPort.delete(structureBuild.getId()));
        collect.forEach(structureBuild -> {
            logger.info("Budynek zbudowany");
            CastleStructure castleStructure = fetchCastleStructureByIdPort.fetchById(structureBuild.getCastleStructureId());
            castleStructure.levelUpStructure(structureBuild.getStructureType());
            updateCastleStructurePort.update(castleStructure.getId(), castleStructure);
        });
    }

//    private final Map<Long, StructureBuild> structureBuildMap; //StructureId,StructureBuild
//
//    public void structureBuildManagerAutoUpdate() {
//        logger.info("structureBuildManagerAutoUpdate");
//        List<Map.Entry<Long, StructureBuild>> collect = structureBuildMap
//                .entrySet()
//                .stream()
//                .filter(e -> e.getValue().getEndDataTime().isBefore(LocalDateTime.now()))
//                .collect(Collectors.toUnmodifiableList());
//        collect.forEach(e->{
//            e.getValue().getStructure().setNextLevel();
//            structureBuildMap.remove(e.getKey());
//        });
//
//    }
//    public void checkIfStructureIsBuilding(Structure structure) {
//        if(structureBuildMap.containsKey(structure.getId())){
//            throw new RuntimeException("Budynek jest aktualnie w budowie");
//        }
//    }
//    public void addStructureBuild(StructureBuild structureBuild){
//        if(Objects.isNull(structureBuildMap.get(structureBuild.getId()))){
//            structureBuildMap.put(structureBuild.getStructure().getId(),structureBuild);
//            logger.info("Budynek dodano do kolejki");
//        }
//    }
//    public void removeStructureBuild(StructureBuild structureBuild){
//        structureBuildMap.remove(structureBuild.getStructure().getId());
//    }
//    public  Map<Long,StructureBuild> getStructureBuildMap(){
//        return Collections.unmodifiableMap(this.structureBuildMap);
//    }


}
