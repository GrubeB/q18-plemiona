package pl.dawid.main.castle.adapter.out.persistence.castle;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import pl.dawid.main.aaShare.EntityMapper;
import pl.dawid.main.castle.adapter.out.persistence.resource.CastleResourceEntity;
import pl.dawid.main.castle.adapter.out.persistence.resource.CastleResourceEntityMapper;
import pl.dawid.main.castle.domain.Castle;

@Mapper(
        uses = {CastleResourceEntityMapper.class}
)
public interface CastleEntityMapper extends EntityMapper<CastleEntity, Castle> {
    CastleEntityMapper INSTANCE = Mappers.getMapper(CastleEntityMapper.class);
    @AfterMapping
    default void updateCastle(CastleEntity castleEntity, @MappingTarget Castle castle) {
        castle.getCastleResourceList().forEach(c->c.setCastle(castle));
    }
    @AfterMapping
    default void updateCastle(Castle source, @MappingTarget CastleEntity castleEntity) {
        castleEntity.getCastleResourceList().forEach(c->c.setCastle(castleEntity));
    }
}
