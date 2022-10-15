package pl.dawid.main.structure.application.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.dawid.main.structure.application.port.in.FetchStructureByIdUseCase;
import pl.dawid.main.structure.application.port.out.structure.FetchStructureByIdPort;
import pl.dawid.main.structure.domain.Structure;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class FetchStructureByIdService implements
        FetchStructureByIdUseCase {

    private final FetchStructureByIdPort fetchByIdPort;
    @Override
    public Structure fetchById(Long id) {
        return fetchByIdPort.fetchStructureById(id);
    }
}
