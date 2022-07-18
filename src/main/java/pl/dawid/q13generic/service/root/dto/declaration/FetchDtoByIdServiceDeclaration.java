package pl.dawid.q13generic.service.root.dto.declaration;

public interface FetchDtoByIdServiceDeclaration<DTO, ID> {
    DTO fetchDtoById(ID id);
}
