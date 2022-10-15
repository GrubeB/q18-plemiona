package pl.dawid.main.structure_builder.application.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.dawid.main.aaShare.core.application.service.FetchByIdService;
import pl.dawid.main.castle.application.port.in.FetchCastleByIdUseCase;
import pl.dawid.main.castle.application.port.out.FetchCastleByIdPort;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.structure_builder.application.port.in.FetchStructureBuildByIdUseCase;
import pl.dawid.main.structure_builder.application.port.out.FetchStructureBuildByIdPort;
import pl.dawid.main.structure_builder.domain.StructureBuild;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class FetchStructureBuildByIdService implements
        FetchStructureBuildByIdUseCase,
        FetchByIdService<StructureBuild> {
    private final FetchStructureBuildByIdPort fetchByIdPort;
}
