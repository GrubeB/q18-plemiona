package pl.dawid.q13generic.controller.root.declaration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface UpdateControllerDeclaration<DTO, UpdateDTO, ID> {
    ResponseEntity<DTO> update(@PathVariable ID id, @RequestBody UpdateDTO updateDto);
}
