package pl.dawid.main.resource.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dawid.main.resource.application.port.out.*;
import pl.dawid.main.resource.domain.CastleResource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class CastleResourcePersistenceAdapter implements
        CreateCastleResourcePort,
        DeleteCasteResourcePort,
        FetchCastleResourceByIdPort,
        FetchAllCastleResourcePort,
        UpdateCastleResourcePort {
    private static Long nextId = 1L;
    private Map<Long, CastleResource> repository = new ConcurrentHashMap<>(10);

    @Override
    public CastleResource create(CastleResource jpaEntity) {
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
    public CastleResource fetchById(Long id) {
        return Optional.ofNullable(repository.get(id)).orElseThrow(() -> new RuntimeException("Not found object with id: " + id));
    }

    @Override
    public List<CastleResource> fetchAll() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public CastleResource update(Long id, CastleResource jpaEntity) {
        fetchById(id);
        repository.put(id, jpaEntity);
        return jpaEntity;
    }
}
