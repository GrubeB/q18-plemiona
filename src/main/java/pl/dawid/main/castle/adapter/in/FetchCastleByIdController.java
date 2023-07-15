package pl.dawid.main.castle.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dawid.main.castle.application.port.in.FetchCastleByIdUseCase;
import pl.dawid.main.castle.domain.Castle;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/castles")
@RequiredArgsConstructor
public class FetchCastleByIdController {
    private final FetchCastleByIdUseCase fetchCastleByIdUseCase;

    @GetMapping("/{id}")
    private ResponseEntity<Castle> fetchById(@PathVariable("id") Long id) {
        Castle castle = fetchCastleByIdUseCase.fetchById(id);
        return ResponseEntity.ok(castle);
    }
}
