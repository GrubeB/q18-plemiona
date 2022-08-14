package pl.dawid.main.castle.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dawid.main.castle.adapter.in.dto.CastleDto;
import pl.dawid.main.castle.adapter.in.dto.CastleDtoMapper;
import pl.dawid.main.castle.application.port.in.*;
import pl.dawid.main.castle.domain.Castle;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(CastleWebController.resourceMapping)
public class CastleWebController {
    public static final String resourceMapping = "/api/castles";
    private final CreateCastleUseCase createCastleService;
    private final FetchCastleByIdUseCase fetchCastleByIdUseCase;
    private final FetchAllCastleUseCase fetchAllCastleUseCase;
    private final AddResourceToCastleUseCase addResourceToCastleUseCase;
    private final SubtractResourceFromCastleUseCase subtractResourceFromCastleUseCase;
    private final CastleDtoMapper castleDtoMapper = CastleDtoMapper.INSTANCE;

    @GetMapping("/{id}")
    ResponseEntity<CastleDto> fetchById(@PathVariable Long id) {
        Castle castle = fetchCastleByIdUseCase.findById(id);
        CastleDto castleDto = castleDtoMapper.map(castle);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(castleDto);
    }
    @GetMapping
    ResponseEntity<List<CastleDto>> fetchAll() {
        List<Castle> castleList = fetchAllCastleUseCase.findAll();
        List<CastleDto> castleDtoList = castleDtoMapper.map(castleList);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(castleDtoList);
    }
    @PostMapping
    ResponseEntity<CastleDto> create(@RequestBody CreateCastleCommand command) {
        Castle castle = createCastleService.createCastle(command);
        CastleDto castleDto = castleDtoMapper.map(castle);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(castleDto);
    }
    @PostMapping("/{id}/addResourceToCastle")
    ResponseEntity<Void> addResourceToCastle(@PathVariable("id") Long castleId, @RequestBody AddResourceToCastleCommand command) {
        addResourceToCastleUseCase.addResourceToCastle(castleId,command);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
    @PostMapping("/{id}/subtractResourceFromCastle")
    ResponseEntity<Void> subtractResourceFromCastle(@PathVariable("id") Long castleId, @RequestBody SubtractResourceFromCastleCommand command) {
        subtractResourceFromCastleUseCase.subtractResourceFromCastle(castleId,command);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
