package pl.dawid.main.castle.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dawid.main.castle.application.port.in.FetchAllCastleUseCase;
import pl.dawid.main.castle.application.port.in.FetchCastleByIdUseCase;
import pl.dawid.main.castle.domain.Castle;

import java.util.List;

@RestController
@RequestMapping("/api/castles")
@RequiredArgsConstructor
public class FetchAllCastleController {
    private final FetchAllCastleUseCase fetchAllCastleUseCase;

    @GetMapping
    private ResponseEntity<List<Castle>> fetchAll() {
        return ResponseEntity.ok(fetchAllCastleUseCase.fetchAll());
    }
}
