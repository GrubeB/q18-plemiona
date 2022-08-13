package pl.dawid.main.castle.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dawid.main.castle.application.CreateCastleService;
import pl.dawid.main.castle.application.port.in.CreateCastleCommand;
import pl.dawid.main.castle.application.port.in.CreateCastleUseCase;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.controller.CastleControllerImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping(CreateCastleController.resourceMapping)
public class CreateCastleController {
    private final CreateCastleUseCase createCastleService;
    public static final String resourceMapping = "/api/castles";

    @PostMapping
    public ResponseEntity<Castle> create(@RequestBody CreateCastleCommand command) {
        Castle castle = createCastleService.createCastle(command);
        //DTO createdDto = getService().createDto(createDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(castle);
    }
}
