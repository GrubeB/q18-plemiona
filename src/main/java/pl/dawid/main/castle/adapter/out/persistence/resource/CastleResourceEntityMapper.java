package pl.dawid.main.castle.adapter.out.persistence.resource;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import pl.dawid.main.aaShare.EntityMapper;
import pl.dawid.main.castle.adapter.out.persistence.castle.CastleEntityMapper;
import pl.dawid.main.castle.domain.CastleResource;

import java.util.List;

@Mapper(
        //componentModel = "spring",
        //injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        //injectionStrategy = InjectionStrategy.FIELD,
        //uses = {CastleEntityMapper.class}
)
public interface CastleResourceEntityMapper extends EntityMapper<CastleResourceEntity, CastleResource> {
    CastleResourceEntityMapper INSTANCE = Mappers.getMapper(CastleResourceEntityMapper.class);

    @Override
    @Mapping(target = "castle.castleResourceList", ignore = true)
    CastleResource mapToDomainObject(CastleResourceEntity source);
    @Override
    @Mapping(target = "castle.castleResourceList", ignore = true)
    CastleResourceEntity mapToJpaEntity(CastleResource source);

    @Named("mapWithoutLoop")
    @Mapping(target = "castle", ignore = true)
    CastleResource mapToDomainObjectWithoutLoop(CastleResourceEntity source);
    @Named("mapWithoutLoop")
    @Mapping(target = "castle", ignore = true)
    CastleResourceEntity mapToJpaEntityWithoutLoop(CastleResource source);

    //    @Override
//    @Mapping(target = "castle", ignore = true)
//    CastleResource mapToDomainObject(CastleResourceEntity source);
//    @Override
//    @Mapping(target = "castle", ignore = true)
//    CastleResourceEntity mapToJpaEntity(CastleResource source);

//    @Override
//    @Mapping(target = "castle",
//            source = "castle",
//            qualifiedByName = "mapWithoutLoop")
//    CastleResource mapToDomainObject(CastleResourceEntity source);
//    @Override
//    @Mapping(target = "castle",
//            source = "castle",
//            qualifiedByName = "mapWithoutLoop")
//    CastleResourceEntity mapToJpaEntity(CastleResource source);






//    @Named("mapToDomainObject2")
//    @Mapping(target = "castle", ignore = true)
//    List<CastleResource> mapToDomainObjectList2(List<CastleResourceEntity> source);
//    @Named("mapToDomainObject2")
//    @Mapping(target = "castle", ignore = true)
//    List<CastleResourceEntity> mapToJpaEntityList2(List<CastleResource> source);

}
