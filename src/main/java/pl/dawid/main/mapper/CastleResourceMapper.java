package pl.dawid.main.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.dawid.main.dto.castleResource.CastleResourceDto;
import pl.dawid.main.dto.castleResource.CastleResourceFlatDto;
import pl.dawid.main.entity.resources.CastleResource;
import pl.dawid.main.mapper.root.FullDtoMapper;
import pl.dawid.main.mapper.root.config.MapStructConfig;

import java.util.List;

//@Mapper(config = MapStructConfig.class)
public interface CastleResourceMapper extends FullDtoMapper<CastleResource, CastleResourceDto, CastleResourceDto, CastleResourceDto> {

    @Mapping(source = "resource.title", target = "title")
    CastleResourceFlatDto mapEntityToFlatDto(CastleResource entity);

    List<CastleResourceFlatDto> mapEntityListToFlatListDto(List<CastleResource> entityList);
}
