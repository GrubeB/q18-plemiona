package pl.dawid.main.controller.root.declaration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface CreateControllerDeclaration<DTO, CreateDTO> {
    ResponseEntity<DTO> create(@RequestBody CreateDTO createDto);
}