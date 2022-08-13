package pl.dawid.main.controller.root;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.dawid.main.controller.root.declaration.UpdateControllerDeclaration;
import pl.dawid.main.entity.root.GEntity;
import pl.dawid.main.service.root.dto.UpdateDtoService;

public interface UpdateController<ENTITY extends GEntity<ID>, DTO, UpdateDTO, ID> extends
        GController,
        UpdateControllerDeclaration<DTO, UpdateDTO, ID> {
    @PutMapping(byId)
    default ResponseEntity<DTO> update(@PathVariable ID id, @RequestBody UpdateDTO updateDto) {
        DTO updatedDto = getService().updateDto(id, updateDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedDto);
    }

    UpdateDtoService<ENTITY, DTO, UpdateDTO, ID> getService();
}
