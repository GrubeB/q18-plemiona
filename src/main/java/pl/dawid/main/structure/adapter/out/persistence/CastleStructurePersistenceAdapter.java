package pl.dawid.main.structure.adapter.out.persistence;

import org.springframework.stereotype.Service;
import pl.dawid.main.structure.CastleStructure;
import pl.dawid.main.structure.application.port.out.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CastleStructurePersistenceAdapter implements
        CreateCastleStructurePort, DeleteCastleStructurePort, FetchAllCastleStructurePort, FetchByIdCastleStructurePort, UpdateCastleStructurePort {

    private static Long nextId = 1L;
    private Map<Long, CastleStructure> repository = new ConcurrentHashMap<>(10);

    @Override
    public CastleStructure create(CastleStructure jpaEntity) {
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
    public List<CastleStructure> fetchAll() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public CastleStructure fetchById(Long id) {
        return Optional.ofNullable(repository.get(id)).orElseThrow(() -> new RuntimeException("Not found object with id: " + id));
    }

    @Override
    public CastleStructure update(Long id, CastleStructure jpaEntity) {
        fetchById(id);
        repository.put(id, jpaEntity);
        return jpaEntity;
    }
}
