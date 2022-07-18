package pl.dawid.q13generic.controller.root.declaration;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FetchAllControllerDeclaration<DTO> {
    ResponseEntity<List<DTO>> fetchAll();
}
