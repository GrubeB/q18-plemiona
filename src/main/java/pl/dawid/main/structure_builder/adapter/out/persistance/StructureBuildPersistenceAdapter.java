package pl.dawid.main.structure_builder.adapter.out.persistance;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.dawid.main.aaShare.core.adapter.out.persistence.*;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.structure_builder.application.port.out.*;
import pl.dawid.main.structure_builder.domain.StructureBuild;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class StructureBuildPersistenceAdapter implements
        CreateStructureBuildPort,
        DeleteStructureBuildPort,
        FetchAllStructureBuildPort,
        FetchStructureBuildByIdPort,
        UpdateStructureBuildPort,

        CreatePersistenceAdapter<StructureBuild>,
        DeletePersistenceAdapter<StructureBuild>,
        FetchAllPersistenceAdapter<StructureBuild>,
        FetchByIdPersistenceAdapter<StructureBuild>,
        UpdatePersistenceAdapter<StructureBuild> {
    private Long nextId = 1L;
    private Map<Long, StructureBuild> repository = new ConcurrentHashMap<>(10);
}
