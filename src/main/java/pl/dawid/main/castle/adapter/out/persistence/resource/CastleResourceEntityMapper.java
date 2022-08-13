package pl.dawid.main.castle.adapter.out.persistence.resource;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.dawid.main.castle.adapter.out.persistence.EntityMapper;
import pl.dawid.main.castle.adapter.out.persistence.castle.CastleEntityMapper;
import pl.dawid.main.castle.domain.CastleResource;
import pl.dawid.main.mapper.root.config.MapStructConfig;

@Mapper(config = MapStructConfig.class)
public interface CastleResourceEntityMapper extends EntityMapper<CastleResourceEntity, CastleResource> {

    CastleResourceEntityMapper INSTANCE = Mappers.getMapper(CastleResourceEntityMapper.class);
//    @Override
//    @Mapping(target = "castle", ignore = true)
//    CastleResource mapToDomainObject(CastleResourceEntity source);
//    @Override
//    @Mapping(target = "castle", ignore = true)
//    CastleResourceEntity mapToJpaEntity(CastleResource source);
}
