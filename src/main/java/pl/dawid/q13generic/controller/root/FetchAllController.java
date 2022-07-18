package pl.dawid.q13generic.controller.root;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import pl.dawid.q13generic.controller.root.declaration.FetchAllControllerDeclaration;
import pl.dawid.q13generic.service.root.dto.FetchDtoAllService;

import java.util.List;

public interface FetchAllController<ENTITY, DTO, ID> extends
        GController,
        FetchAllControllerDeclaration<DTO> {
    @GetMapping
    default ResponseEntity<List<DTO>> fetchAll() {
        List<DTO> dtoList = getService().fetchDtoAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dtoList);
    }

    FetchDtoAllService<ENTITY, DTO, ID> getService();
}
