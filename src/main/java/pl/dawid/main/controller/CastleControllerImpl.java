package pl.dawid.main.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dawid.main.dto.castle.CastleDto;
import pl.dawid.main.dto.castleResource.CastleResourceFlatDto;
import pl.dawid.main.service.CastleResourceService;
import pl.dawid.main.service.CastleService;

import java.util.List;

//@RestController
@Getter
@AllArgsConstructor
//@RequestMapping(CastleControllerImpl.resourceMapping)
public class CastleControllerImpl implements CastleController {

    public static final String resourceMapping = "/castles";
    private CastleService service;
    private CastleResourceService castleResourceService;

    @GetMapping("/new")
    public ResponseEntity<CastleDto> createNewCastle(){
        CastleDto castleDto = service.createNewCastle("Nova");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(castleDto);
    }

    @GetMapping("/{castle_id}/resources")
    public ResponseEntity<List<CastleResourceFlatDto>> fetchCastleResourcesByCastleId(@PathVariable Long castle_id){
        List<CastleResourceFlatDto> castleResourceFlatDtos = castleResourceService.fetchCastleResourcesByCastleId(castle_id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(castleResourceFlatDtos);
    }

    @PostMapping("/{castle_id}/resources")
    public ResponseEntity<List<CastleResourceFlatDto>> addCastleResourcesByCastleId(@PathVariable Long castle_id, @RequestBody List<CastleResourceFlatDto> castleResourceFlatDtoList){
        List<CastleResourceFlatDto> castleResourceFlatDtos = castleResourceService.addCastleResourcesByCastleId(castle_id, castleResourceFlatDtoList);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(castleResourceFlatDtos);
    }
}
