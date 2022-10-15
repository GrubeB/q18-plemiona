package pl.dawid.main.structure_builder.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dawid.main.resource.domain.CastleResource;
import pl.dawid.main.structure.CastleStructure;
import pl.dawid.main.structure.application.port.in.FetchCastleStructureByIdUseCase;
import pl.dawid.main.structure.application.port.in.FetchStructureByIdUseCase;
import pl.dawid.main.structure.domain.Structure;
import pl.dawid.main.structure_blueprint.domain.StructureType;
import pl.dawid.main.structure_builder.adapter.in.StructureBuildManager;
import pl.dawid.main.structure_builder.application.port.in.FetchAllStructureBuildUseCase;
import pl.dawid.main.structure_builder.application.port.in.FetchStructureBuildByIdUseCase;
import pl.dawid.main.structure_builder.application.port.in.LevelUpStructurePort;
import pl.dawid.main.structure_builder.application.port.in.dto.LevelUpStructureCommand;
import pl.dawid.main.structure_builder.application.port.out.FetchAllStructureBuildPort;
import pl.dawid.main.structure_builder.application.port.out.FetchStructureBuildByIdPort;
import pl.dawid.main.structure_builder.domain.StructureBuild;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StructureBuildService implements
        LevelUpStructurePort {


    private final FetchAllStructureBuildPort fetchAllStructureBuildPort;
    private final FetchStructureBuildByIdPort fetchStructureBuildByIdPort;



    private final FetchCastleStructureByIdUseCase fetchCastleStructureByIdUseCase;
    private final FetchStructureByIdUseCase fetchStructureByIdUseCase;



    @Override
    public void levelUpStructure(LevelUpStructureCommand command) {
        CastleStructure castleStructure = fetchCastleStructureByIdUseCase.fetchById(command.getCastleStructureId());
        Structure structure = fetchStructureByIdUseCase.fetchStructureById(command.getStructureId());

    }
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
//    @Override
//    public Castle create(CreateCastleCommand command) {
//        Castle castle = structureBuildFactory.createCastle(command.getName());
//        castle = createCastlePort.create(castle);
//        CastleResource castleResource = createCastleResourceUseCase.create(new CreateCastleResourceCommand(castle.getId()));
//        castle.setCastleResource(castleResource);
//
//        CastleStructure castleStructure = createCastleStructureUseCase.create(new CreateCastleStructureCommand(castle.getId()));
//        castle.setCastleStructure(castleStructure);
//
//        return updateCastlePort.update(castle.getId(), castle);
//    }
}
