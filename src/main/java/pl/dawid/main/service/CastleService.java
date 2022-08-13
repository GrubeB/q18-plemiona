package pl.dawid.main.service;

import pl.dawid.main.dto.castle.CastleCreateDto;
import pl.dawid.main.dto.castle.CastleDto;
import pl.dawid.main.dto.castle.CastleUpdateDto;
import pl.dawid.main.entity.castle.Castle;
import pl.dawid.main.service.root.FullService;

public interface CastleService extends FullService<Castle, CastleDto, CastleUpdateDto, CastleCreateDto, Long>{
    CastleDto createNewCastle(String name);
}
