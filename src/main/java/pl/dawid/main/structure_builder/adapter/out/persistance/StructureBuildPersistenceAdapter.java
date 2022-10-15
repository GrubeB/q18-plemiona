package pl.dawid.main.structure_builder.adapter.out.persistance;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dawid.main.structure_builder.application.port.out.*;
import pl.dawid.main.structure_builder.domain.StructureBuild;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class StructureBuildPersistenceAdapter implements
        CreateStructureBuildPort,
        DeleteStructureBuildPort,
        FetchAllStructureBuildPort,
        FetchStructureBuildByIdPort,
        UpdateStructureBuildPort {
    private static Long nextId = 1L;
    private Map<Long, StructureBuild> repository = new ConcurrentHashMap<>(10);

    @Override
    public StructureBuild create(StructureBuild jpaEntity) {
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
    public StructureBuild fetchById(Long id) {
        return Optional.ofNullable(repository.get(id)).orElseThrow(() -> new RuntimeException("Not found object with id: " + id));
    }

    @Override
    public List<StructureBuild> fetchAll() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public StructureBuild update(Long id, StructureBuild jpaEntity) {
        fetchById(id);
        repository.put(id, jpaEntity);
        return jpaEntity;
    }
}
