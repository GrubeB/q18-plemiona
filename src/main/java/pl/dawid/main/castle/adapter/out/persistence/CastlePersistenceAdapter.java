package pl.dawid.main.castle.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dawid.main.castle.application.port.out.*;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.resource.application.port.out.*;
import pl.dawid.main.resource.domain.CastleResource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class CastlePersistenceAdapter implements
        CreateCastlePort,
        FetchAllCastlePort,
        FetchCastleByIdPort,
        UpdateCastlePort,
        DeleteCastePort {
    private static Long nextId = 1L;
    private Map<Long, Castle> repository = new ConcurrentHashMap<>(10);

    @Override
    public Castle create(Castle jpaEntity) {
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
    public Castle fetchById(Long id) {
        return Optional.ofNullable(repository.get(id)).orElseThrow(() -> new RuntimeException("Not found object with id: " + id));
    }

    @Override
    public List<Castle> fetchAll() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public Castle update(Long id, Castle jpaEntity) {
        fetchById(id);
        repository.put(id, jpaEntity);
        return jpaEntity;
    }
}
