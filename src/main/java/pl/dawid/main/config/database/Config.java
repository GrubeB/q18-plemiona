package pl.dawid.main.config.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.dawid.main.entity.resources.Resource;
import pl.dawid.main.entity.resources.ResourceType;
import pl.dawid.main.entity.structure.Structure;
import pl.dawid.main.entity.structure.StructureLevel;
import pl.dawid.main.entity.structure.StructureLevelResource;
import pl.dawid.main.entity.structure.StructureType;
import pl.dawid.main.repository.ResourceRepository;
import pl.dawid.main.repository.StructureLevelRepository;
import pl.dawid.main.repository.StructureLevelResourceRepository;
import pl.dawid.main.repository.StructureRepository;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//@Service
@Setter
@Getter
@AllArgsConstructor
public class Config {
    private ResourceRepository resourceRepository;
    private StructureRepository structureRepository;
    private StructureLevelRepository structureLevelRepository;

    private StructureLevelResourceRepository structureLevelResourceRepository;

    private Map<ResourceType, Resource> resourceMap;
    private Map<StructureType, Structure> structureMap;
    private Map<StructureType, List<StructureLevel>> structureLevelListMap;

    public void init() {
        resourceConfig();
        structureConfig();
        //structureLevelConfig();
    }

    private void structureLevelConfig() {
        //---------------------------------------------------0---------------------------------------------------------
        StructureLevel structureLevel0 = new StructureLevel(0, Duration.ofSeconds(60), structureMap.get(StructureType.HEADQUARTERS));
        structureLevel0=structureLevelRepository.saveAndFlush(structureLevel0);

        List<StructureLevelResource> structureLeve0lResource = Arrays.asList(
                new StructureLevelResource(100L,structureLevel0, resourceMap.get(ResourceType.WOOD)),
                new StructureLevelResource(100L,structureLevel0, resourceMap.get(ResourceType.CLAY)),
                new StructureLevelResource(100L,structureLevel0, resourceMap.get(ResourceType.IRON)),
                new StructureLevelResource(1L,structureLevel0, resourceMap.get(ResourceType.EMPLOYEE))
        );
        structureLeve0lResource = structureLevelResourceRepository.saveAllAndFlush(structureLeve0lResource);

        structureLevel0.setStructureLevelResourceList(structureLeve0lResource);
        structureLevel0=structureLevelRepository.saveAndFlush(structureLevel0);

//        //---------------------------------------------------1---------------------------------------------------------
//        StructureLevel structureLevel1 = new StructureLevel(1, Duration.ofSeconds(120), structureMap.get(StructureType.HEADQUARTERS));
//        structureLevel1=structureLevelRepository.saveAndFlush(structureLevel1);
//
//        List<StructureLevelResource> structureLeve1lResource = Arrays.asList(
//                new StructureLevelResource(200L,structureLevel0, resourceMap.get(ResourceType.WOOD)),
//                new StructureLevelResource(200L,structureLevel0, resourceMap.get(ResourceType.CLAY)),
//                new StructureLevelResource(200L,structureLevel0, resourceMap.get(ResourceType.IRON)),
//                new StructureLevelResource(2L,structureLevel0, resourceMap.get(ResourceType.EMPLOYEE))
//        );
//        structureLeve1lResource = structureLevelResourceRepository.saveAllAndFlush(structureLeve1lResource);
//
//        structureLevel1.setStructureLevelResourceList(structureLeve1lResource);
//        structureLevel1=structureLevelRepository.saveAndFlush(structureLevel1);
//
//        structureLevelListMap.put(StructureType.HEADQUARTERS, Arrays.asList(structureLevel0,structureLevel1));
    }

    private void structureConfig() {
        Arrays.stream(StructureType.values()).forEach((value) -> {
            Structure structure = structureRepository.saveAndFlush(new Structure(value));
            structureMap.put(value, structure);
        });
    }

    void resourceConfig() {
        Arrays.stream(ResourceType.values()).forEach((value) -> {
            Resource resource = resourceRepository.saveAndFlush(new Resource(value));
            resourceMap.put(value, resource);
        });
    }
}