package pl.dawid.main.castle.adapter.out.persistence;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.dawid.main.aaShare.core.adapter.out.persistence.*;
import pl.dawid.main.castle.application.port.out.*;
import pl.dawid.main.castle.domain.Castle;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class CastlePersistenceAdapter implements
        CreateCastlePort,
        FetchAllCastlePort,
        FetchCastleByIdPort,
        UpdateCastlePort,
        DeleteCastePort,

        CreatePersistenceAdapter<Castle>,
        DeletePersistenceAdapter<Castle>,
        FetchAllPersistenceAdapter<Castle>,
        FetchByIdPersistenceAdapter<Castle>,
        UpdatePersistenceAdapter<Castle> {
    private Long nextId = 1L;
    private Map<Long, Castle> repository = new ConcurrentHashMap<>(10);

    @Override
    public Castle fetchById(Long id) {
        return FetchByIdPersistenceAdapter.super.fetchById(id);
    }
}
