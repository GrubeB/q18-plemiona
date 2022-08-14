package pl.dawid.main.castle.adapter.out.persistence.castle;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import pl.dawid.main.aaShare.EntityMapper;
import pl.dawid.main.castle.adapter.out.persistence.resource.CastleResourceEntityMapper;
import pl.dawid.main.castle.domain.Castle;

@Mapper(
        uses = {CastleResourceEntityMapper.class},
        //componentModel = "spring",
        //injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        //injectionStrategy = InjectionStrategy.FIELD,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED
)
public interface CastleEntityMapper extends EntityMapper<CastleEntity, Castle> {
    CastleEntityMapper INSTANCE = Mappers.getMapper(CastleEntityMapper.class);

    @Override
    @Mapping(target = "castleResourceList", source = "castleResourceList", qualifiedByName = "mapWithoutLoop")
    Castle mapToDomainObject(CastleEntity source);
    @Override
    @Mapping(target = "castleResourceList", source = "castleResourceList", qualifiedByName = "mapWithoutLoop")
    CastleEntity mapToJpaEntity(Castle source);

//    @Named("mapWithoutLoop")
//    @Mapping(target = "castleResourceList", ignore = true)
//    Castle mapToDomainObjectWithoutLoop(CastleEntity source);
//
//    @Named("mapWithoutLoop")
//    @Mapping(target = "castleResourceList", ignore = true)
//    CastleEntity mapToJpaEntityWithoutLoop(Castle source);

    @AfterMapping
    default void updateCastle(CastleEntity castleEntity, @MappingTarget Castle castle) {
        castle.getCastleResourceList().forEach(c->c.setCastle(castle));
    }
    @AfterMapping
    default void updateCastle(Castle source, @MappingTarget CastleEntity castleEntity) {
        castleEntity.getCastleResourceList().forEach(c->c.setCastle(castleEntity));
    }
}
