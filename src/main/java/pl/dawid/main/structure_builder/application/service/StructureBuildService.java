package pl.dawid.main.structure_builder.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dawid.main.resource.application.port.in.FetchCastleResourceByIdUseCase;
import pl.dawid.main.resource.domain.BaseResource;
import pl.dawid.main.resource.domain.CastleResource;
import pl.dawid.main.structure.CastleStructure;
import pl.dawid.main.structure.application.port.in.CreateStructureUseCase;
import pl.dawid.main.structure.application.port.in.FetchCastleStructureByIdUseCase;
import pl.dawid.main.structure.application.port.in.dto.CreateStructureCommand;
import pl.dawid.main.structure.domain.Structure;
import pl.dawid.main.structure_blueprint.application.port.out.FetchStructureBlueprintByStructureTypePort;
import pl.dawid.main.structure_blueprint.domain.StructureBlueprint;
import pl.dawid.main.structure_blueprint.domain.StructureLevel;
import pl.dawid.main.structure_blueprint.domain.StructureType;
import pl.dawid.main.structure_builder.adapter.in.StructureBuildManager;
import pl.dawid.main.structure_builder.application.StructureBuildFactory;
import pl.dawid.main.structure_builder.application.port.in.BuildStructureUseCase;
import pl.dawid.main.structure_builder.application.port.in.LevelUpStructureUseCase;
import pl.dawid.main.structure_builder.application.port.in.dto.BuildStructureCommand;
import pl.dawid.main.structure_builder.application.port.in.dto.LevelUpStructureCommand;
import pl.dawid.main.structure_builder.application.port.out.CreateStructureBuildPort;
import pl.dawid.main.structure_builder.domain.StructureBuild;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StructureBuildService implements
        LevelUpStructureUseCase,
        BuildStructureUseCase {

    // structure build
    private final StructureBuildFactory structureBuildFactory;
    private final CreateStructureBuildPort createStructureBuildPort;
    // structure
    private final FetchCastleStructureByIdUseCase fetchCastleStructureByIdUseCase;

    private final CreateStructureUseCase createStructureUseCase;

    // structure blueprint
    private final FetchStructureBlueprintByStructureTypePort fetchStructureBlueprintByStructureTypePort;

    // resources
    private final FetchCastleResourceByIdUseCase fetchCastleResourceByIdUseCase;



    @Override
    public void buildStructure(BuildStructureCommand command) {
        CastleStructure castleStructure = fetchCastleStructureByIdUseCase.fetchById(command.getCastleStructureId());
        castleStructure.verifyIfStructureIsNotBuilt(command.getStructureType());
        // verify requirements
        StructureBlueprint structureBlueprint = fetchStructureBlueprintByStructureTypePort.fetchByStructureType(command.getStructureType());
        StructureLevel firstStructureLevel = structureBlueprint.getFirstStructureLevel();

        // verify if enough resources
        List<BaseResource> resourceList = firstStructureLevel.getResourceList();
        CastleResource castleResource = fetchCastleResourceByIdUseCase.fetchById(command.getCastleResourceId());
        castleResource.verifyIfIsEnoughResourceList(resourceList);

        // built
        castleResource.subtractResourceList(resourceList);
        Structure structure = createStructureUseCase.create(new CreateStructureCommand(
                command.getCastleStructureId(),
                command.getStructureType()));
        StructureBuild structureBuild =new StructureBuild(null,
                castleStructure.getId(),
                structure.getStructureType(),
                LocalDateTime.now(),
                LocalDateTime.now().plusSeconds(firstStructureLevel.getDuration().getSeconds()));
        createStructureBuildPort.create(structureBuild);
    }

    @Override
    public void levelUpStructure(LevelUpStructureCommand command) {
        CastleStructure castleStructure = fetchCastleStructureByIdUseCase.fetchById(command.getCastleStructureId());
        castleStructure.verifyIfStructureIsBuilt(command.getStructureType());
        Structure structure = castleStructure.getStructureObjectByStructureType(command.getStructureType());

        // verify requirements
        StructureBlueprint structureBlueprint = fetchStructureBlueprintByStructureTypePort.fetchByStructureType(command.getStructureType());
        StructureLevel structureLevel = structureBlueprint.getNextStructureLevel(structure.getLevel());

        // verify if enough resources
        List<BaseResource> resourceList = structureLevel.getResourceList();
        CastleResource castleResource = fetchCastleResourceByIdUseCase.fetchById(command.getCastleResourceId());
        castleResource.verifyIfIsEnoughResourceList(resourceList);

        // built
        castleResource.subtractResourceList(resourceList);
        StructureBuild structureBuild =new StructureBuild(null,
                castleStructure.getId(),
                structure.getStructureType(),
                LocalDateTime.now(),
                LocalDateTime.now().plusSeconds(structureLevel.getDuration().getSeconds()));
        createStructureBuildPort.create(structureBuild);
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
