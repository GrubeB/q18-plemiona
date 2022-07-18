package pl.dawid.q13generic.service.root.dto.declaration;

import java.util.List;

public interface FetchDtoAllServiceDeclaration<DTO> {
    List<DTO> fetchDtoAll();
}
