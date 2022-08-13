package pl.dawid.main.service.root.dto.declaration;

public interface FetchDtoByIdServiceDeclaration<DTO, ID> {
    DTO fetchDtoById(ID id);

    void beforeFetchDtoById(ID id);

    void afterFetchDtoById(ID id, DTO dto);
}
