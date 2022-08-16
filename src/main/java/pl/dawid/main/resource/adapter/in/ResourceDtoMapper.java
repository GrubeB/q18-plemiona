package pl.dawid.main.resource.adapter.in;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.dawid.main.aaShare.DtoMapper;
import pl.dawid.main.resource.domain.Resource;

@Mapper
public interface ResourceDtoMapper extends DtoMapper<Resource, ResourceDto> {
    ResourceDtoMapper INSTANCE = Mappers.getMapper(ResourceDtoMapper.class);
}
