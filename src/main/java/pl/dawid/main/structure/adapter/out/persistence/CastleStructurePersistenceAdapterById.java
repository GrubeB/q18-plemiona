package pl.dawid.main.structure.adapter.out.persistence;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.dawid.main.aaShare.core.adapter.out.persistence.*;
import pl.dawid.main.structure.CastleStructure;
import pl.dawid.main.structure.application.port.out.*;
import pl.dawid.main.structure.domain.Structure;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class CastleStructurePersistenceAdapterById implements
        FetchStructureByIdPort,

        CreateCastleStructurePort,
        DeleteCastleStructurePort,
        FetchAllCastleStructurePort,
        FetchCastleStructureByIdPort,
        UpdateCastleStructurePort,
        CreatePersistenceAdapter<CastleStructure>,
        DeletePersistenceAdapter<CastleStructure>,
        FetchAllPersistenceAdapter<CastleStructure>,
        FetchByIdPersistenceAdapter<CastleStructure>,
        UpdatePersistenceAdapter<CastleStructure> {

    private Long nextId = 1L;
    private Map<Long, CastleStructure> repository = new ConcurrentHashMap<>(10);

    @Override
    public Structure fetchStructureById(Long id) {
        return repository.values().stream()
                .map(castleStructure -> castleStructure.getStructureMap().values())
                .flatMap(Collection::stream)
                .filter(structure -> structure.getId().equals(id))
                .findFirst().orElseThrow(() -> new RuntimeException("Not found object with id: " + id));
    }
}
