package pl.dawid.main.structure_builder.application.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.dawid.main.aaShare.core.application.service.FetchAllService;
import pl.dawid.main.castle.application.port.in.FetchAllCastleUseCase;
import pl.dawid.main.castle.application.port.out.FetchAllCastlePort;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.structure_builder.application.port.in.FetchAllStructureBuildUseCase;
import pl.dawid.main.structure_builder.application.port.out.FetchAllStructureBuildPort;
import pl.dawid.main.structure_builder.domain.StructureBuild;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class FetchAllStructureBuildService implements
        FetchAllStructureBuildUseCase,
        FetchAllService<StructureBuild> {
    private final FetchAllStructureBuildPort fetchAllPort;
}
