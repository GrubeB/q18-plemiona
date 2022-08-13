package pl.dawid.main.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import pl.dawid.main.dto.castle.CastleDto;
import pl.dawid.main.entity.castle.Castle;
import pl.dawid.main.entity.resources.CastleResource;
import pl.dawid.main.entity.resources.ResourceType;
import pl.dawid.main.mapper.CastleMapper;
import pl.dawid.main.repository.CastleRepository;

import java.util.Arrays;
import java.util.List;

//@Service
@Getter
@AllArgsConstructor
public class CastleServiceImpl implements CastleService {
    private CastleRepository repository;
    private CastleMapper mapper;
    private CastleMapper createMapper;
    private CastleMapper updateMapper;

    private ResourceService resourceService;

    @Override
    public CastleDto createNewCastle(String name) {
        Castle castle = new Castle(name,1L,1L);
        List<CastleResource> castleResources = Arrays.asList(
                new CastleResource(castle, resourceService.getResourceByType(ResourceType.WOOD), 0L),
                new CastleResource(castle, resourceService.getResourceByType(ResourceType.CLAY), 0L),
                new CastleResource(castle, resourceService.getResourceByType(ResourceType.IRON), 0L),
                new CastleResource(castle, resourceService.getResourceByType(ResourceType.EMPLOYEE), 0L)
        );
        castleResources.forEach((castleResource)->{
            castleResource.setCastle(castle);
        });
        castle.setCastleResourceList(castleResources);

        Castle savedEntity = createEntity(castle);
        CastleDto castleDto = mapper.mapEntityToDto(savedEntity);
        return castleDto;
    }

    @Override
    public void beforeCreateEntity(Castle castle) {
        castle.getCastleResourceList().forEach((castleResource)->{
            castleResource.setCastle(castle);
        });

    }
}
