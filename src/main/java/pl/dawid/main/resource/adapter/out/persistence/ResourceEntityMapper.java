package pl.dawid.main.resource.adapter.out.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.dawid.main.aaShare.EntityMapper;
import pl.dawid.main.resource.domain.Resource;

@Mapper
public interface ResourceEntityMapper extends
        EntityMapper<ResourceEntity, Resource> {
    ResourceEntityMapper INSTANCE = Mappers.getMapper(ResourceEntityMapper.class);

}
