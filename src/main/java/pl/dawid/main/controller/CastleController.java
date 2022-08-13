package pl.dawid.main.controller;


import org.springframework.http.ResponseEntity;
import pl.dawid.main.controller.root.FullController;
import pl.dawid.main.dto.castle.CastleCreateDto;
import pl.dawid.main.dto.castle.CastleDto;
import pl.dawid.main.dto.castle.CastleUpdateDto;
import pl.dawid.main.entity.castle.Castle;
import pl.dawid.main.service.CastleService;

public interface CastleController extends
        FullController<Castle, CastleDto, CastleUpdateDto, CastleCreateDto, Long> {
    CastleService getService();

    ResponseEntity<CastleDto> createNewCastle();
}
