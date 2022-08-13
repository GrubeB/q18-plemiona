package pl.dawid.main.castle.adapter.in.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.dawid.main.aaShare.DtoMapper;
import pl.dawid.main.castle.domain.Castle;

@Mapper(
        uses = {CastleResourceDtoMapper.class}
)
public interface CastleDtoMapper extends DtoMapper<Castle, CastleDto> {
    CastleDtoMapper INSTANCE = Mappers.getMapper(CastleDtoMapper.class);
}
