package pl.dawid.main.controller.root;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.dawid.main.controller.root.declaration.FetchByIdControllerDeclaration;
import pl.dawid.main.service.root.dto.FetchDtoByIdlService;

public interface FetchByIdController<ENTITY, DTO, ID> extends
        GController,
        FetchByIdControllerDeclaration<DTO, ID> {
    @GetMapping(byId)
    default ResponseEntity<DTO> fetchById(@PathVariable ID id) {
        DTO dto = getService().fetchDtoById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dto);
    }

    FetchDtoByIdlService<ENTITY, DTO, ID> getService();
}