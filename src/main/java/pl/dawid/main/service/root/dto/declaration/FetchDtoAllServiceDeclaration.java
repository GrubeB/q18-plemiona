package pl.dawid.main.service.root.dto.declaration;

import java.util.List;

public interface FetchDtoAllServiceDeclaration<DTO> {
    List<DTO> fetchDtoAll();
    void beforeFetchDtoAll();
    void afterFetchDtoAll(List<DTO> dtoList);
}
