package pl.dawid.main.mapper;

import org.mapstruct.Mapper;
import pl.dawid.main.dto.castle.CastleCreateDto;
import pl.dawid.main.dto.castle.CastleDto;
import pl.dawid.main.dto.castle.CastleUpdateDto;
import pl.dawid.main.entity.castle.Castle;
import pl.dawid.main.mapper.root.FullDtoMapper;
import pl.dawid.main.mapper.root.config.MapStructConfig;

//@Mapper(config = MapStructConfig.class)
public interface CastleMapper extends FullDtoMapper<Castle, CastleDto, CastleUpdateDto, CastleCreateDto> {
}
