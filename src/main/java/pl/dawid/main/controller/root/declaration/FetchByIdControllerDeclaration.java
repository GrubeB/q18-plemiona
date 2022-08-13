package pl.dawid.main.controller.root.declaration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface FetchByIdControllerDeclaration<DTO, ID> {
    ResponseEntity<DTO> fetchById(@PathVariable ID id);
}
