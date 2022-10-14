package pl.dawid.main.structure_blueprint.adapter.out.persistence;

import org.springframework.stereotype.Service;
import pl.dawid.main.structure_blueprint.application.port.out.*;
import pl.dawid.main.structure_blueprint.domain.StructureBlueprint;
import pl.dawid.main.structure_blueprint.domain.enums.StructureType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class StructBlueprintPersistenceAdapter implements
        CreatePort, DeletePort, FetchAllPort, FetchByIdPort, FetchByStructureTypePort {

    private static Long nextId = 1L;
    private Map<Long, StructureBlueprint> repository = new ConcurrentHashMap<>(10);

    @Override
    public StructureBlueprint create(StructureBlueprint jpaEntity) {
        nextId++;
        jpaEntity.setId(nextId);
        repository.put(nextId, jpaEntity);
        return jpaEntity;
    }

    @Override
    public void delete(Long id) {
        repository.remove(id);
    }

    @Override
    public List<StructureBlueprint> fetchAll() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public StructureBlueprint fetchById(Long id) {
        return Optional.ofNullable(repository.get(id)).orElseThrow(() -> new RuntimeException("Not found object with id: " + id));

    }
    @Override
    public StructureBlueprint fetchByStructureType(StructureType structureType) {
        return repository.values().stream()
                .filter(structureBlueprint -> structureBlueprint.getStructureType().equals(structureType))
                .findAny().orElseThrow(() -> new RuntimeException("Not found object with type: " + structureType));
    }
}
