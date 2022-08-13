package pl.dawid.main.controller.root;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.dawid.main.controller.root.declaration.CreateControllerDeclaration;
import pl.dawid.main.service.root.dto.CreateDtoService;

public interface CreateController<ENTITY, DTO, CreateDTO, ID> extends
        GController,
        CreateControllerDeclaration<DTO, CreateDTO> {
    @PostMapping
    default ResponseEntity<DTO> create(@RequestBody CreateDTO createDto) {
        DTO createdDto = getService().createDto(createDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdDto);
    }

    CreateDtoService<ENTITY, DTO, CreateDTO, ID> getService();
}
