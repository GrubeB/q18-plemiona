package pl.dawid.main.service;

import pl.dawid.main.dto.castleResource.CastleResourceDto;
import pl.dawid.main.dto.castleResource.CastleResourceFlatDto;
import pl.dawid.main.entity.resources.CastleResource;
import pl.dawid.main.service.root.FullService;

import java.util.List;

public interface CastleResourceService extends FullService<CastleResource, CastleResourceDto, CastleResourceDto, CastleResourceDto, Long> {

    List<CastleResourceFlatDto> fetchCastleResourcesByCastleId(Long castleId);
    List<CastleResourceFlatDto> addCastleResourcesByCastleId(Long castleId, List<CastleResourceFlatDto> CastleResourceFlatDtoList);
}
