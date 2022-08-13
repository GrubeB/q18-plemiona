package pl.dawid.main.service.root.dto.declaration;

public interface FetchDtoByIdServiceDeclaration<DTO, ID> {
    DTO fetchDtoById(ID id);
}
