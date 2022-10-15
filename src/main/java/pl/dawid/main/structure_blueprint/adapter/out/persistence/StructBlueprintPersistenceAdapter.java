package pl.dawid.main.structure_blueprint.adapter.out.persistence;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.dawid.main.aaShare.core.adapter.out.persistence.*;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.structure_blueprint.application.port.out.*;
import pl.dawid.main.structure_blueprint.domain.StructureBlueprint;
import pl.dawid.main.structure_blueprint.domain.StructureType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class StructBlueprintPersistenceAdapter implements
        FetchStructureBlueprintByStructureTypePort,

        CreateStructureBlueprintPort,
        DeleteStructureBlueprintPort,
        FetchAllStructureBlueprintPort,
        FetchStructureBlueprintByIdPort,

        CreatePersistenceAdapter<StructureBlueprint>,
        DeletePersistenceAdapter<StructureBlueprint>,
        FetchAllPersistenceAdapter<StructureBlueprint>,
        FetchByIdPersistenceAdapter<StructureBlueprint>,
        UpdatePersistenceAdapter<StructureBlueprint> {

    private Long nextId = 1L;
    private Map<Long, StructureBlueprint> repository = new ConcurrentHashMap<>(10);

    @Override
    public StructureBlueprint fetchByStructureType(StructureType structureType) {
        return repository.values().stream()
                .filter(structureBlueprint -> structureBlueprint.getStructureType().equals(structureType))
                .findAny().orElseThrow(() -> new RuntimeException("Not found object with type: " + structureType));
    }
}
