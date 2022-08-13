package pl.dawid.main.castle.adapter.in.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.dawid.main.aaShare.DtoMapper;
import pl.dawid.main.castle.domain.CastleResource;

@Mapper
public interface CastleResourceDtoMapper extends DtoMapper<CastleResource, CastleResourceDto> {
    CastleResourceDtoMapper INSTANCE = Mappers.getMapper(CastleResourceDtoMapper.class);
}
