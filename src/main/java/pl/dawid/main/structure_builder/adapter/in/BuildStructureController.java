package pl.dawid.main.structure_builder.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dawid.main.structure_builder.application.port.in.BuildStructureUseCase;
import pl.dawid.main.structure_builder.application.port.in.LevelUpStructureUseCase;
import pl.dawid.main.structure_builder.application.port.in.dto.BuildStructureCommand;
import pl.dawid.main.structure_builder.application.port.in.dto.LevelUpStructureCommand;

@RestController
@RequestMapping("/api/structure-build")
@RequiredArgsConstructor
public class BuildStructureController {
    private final BuildStructureUseCase buildStructureUseCase;
    private final LevelUpStructureUseCase levelUpStructureUseCase;

    @PostMapping("/build")
    private ResponseEntity<?> buildStructure(@RequestBody BuildStructureCommand command) {
        buildStructureUseCase.buildStructure(command);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/level-up")
    private ResponseEntity<?> levelUpStructure(@RequestBody LevelUpStructureCommand command) {
        levelUpStructureUseCase.levelUpStructure(command);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
