package pl.dawid.main.service.root.dto.declaration;

public interface CreateDtoServiceDeclaration<DTO, CreateDTO> {
    DTO createDto(CreateDTO createDTO);
    void beforeCreateDto(CreateDTO createDTO);
    void afterCreateDto(DTO dto);
}
