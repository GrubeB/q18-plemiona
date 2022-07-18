package pl.dawid.q13generic.service.root.dto.declaration;

public interface CreateDtoServiceDeclaration<DTO, CreateDTO> {
    DTO createDto(CreateDTO createDTO);
}
