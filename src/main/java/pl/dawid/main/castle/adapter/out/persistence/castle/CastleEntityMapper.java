package pl.dawid.main.castle.adapter.out.persistence.castle;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.dawid.main.aaShare.EntityMapper;
import pl.dawid.main.castle.adapter.out.persistence.resource.CastleResourceEntityMapper;
import pl.dawid.main.castle.domain.Castle;

@Mapper(
        uses = {CastleResourceEntityMapper.class}
)
public interface CastleEntityMapper extends EntityMapper<CastleEntity, Castle> {
    CastleEntityMapper INSTANCE = Mappers.getMapper(CastleEntityMapper.class);
}
