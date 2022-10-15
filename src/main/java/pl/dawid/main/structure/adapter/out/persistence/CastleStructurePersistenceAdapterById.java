package pl.dawid.main.structure.adapter.out.persistence;

import org.springframework.stereotype.Service;
import pl.dawid.main.structure.CastleStructure;
import pl.dawid.main.structure.application.port.out.*;
import pl.dawid.main.structure.domain.Structure;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CastleStructurePersistenceAdapterById implements
        CreateCastleStructurePort,
        DeleteCastleStructurePort,
        FetchAllCastleStructurePort,
        FetchCastleStructureByIdPort,
        UpdateCastleStructurePort,
        FetchStructureByIdPort{

    private static Long nextId = 1L;
    private Map<Long, CastleStructure> repository = new ConcurrentHashMap<>(10);

    @Override
    public Structure fetchStructureById(Long id) {
        return repository.values().stream()
                .map(castleStructure -> castleStructure.getStructureMap().values())
                .flatMap(Collection::stream)
                .filter(structure -> structure.getId().equals(id))
                .findFirst().orElseThrow(() -> new RuntimeException("Not found object with id: " + id));
    }

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
