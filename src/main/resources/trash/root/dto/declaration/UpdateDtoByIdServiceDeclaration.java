package pl.dawid.main.service.root.dto.declaration;

public interface UpdateDtoByIdServiceDeclaration<DTO, UpdateDTO, ID> {
    DTO updateDto(ID id, UpdateDTO updateDTO);
}
