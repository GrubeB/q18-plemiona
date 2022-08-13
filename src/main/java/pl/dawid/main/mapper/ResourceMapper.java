package pl.dawid.main.mapper;

import org.mapstruct.Mapper;
import pl.dawid.main.dto.resource.ResourceDto;
import pl.dawid.main.entity.resources.Resource;
import pl.dawid.main.mapper.root.FullDtoMapper;
import pl.dawid.main.mapper.root.config.MapStructConfig;

//@Mapper(config = MapStructConfig.class)
public interface ResourceMapper extends FullDtoMapper<Resource, ResourceDto, ResourceDto, ResourceDto> {
}
