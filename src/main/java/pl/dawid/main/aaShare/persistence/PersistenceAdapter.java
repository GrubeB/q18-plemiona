package pl.dawid.main.aaShare.persistence;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.dawid.main.castle.application.port.out.*;
import pl.dawid.main.castle.domain.Castle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;


@Getter
@Setter
@RequiredArgsConstructor
public class PersistenceAdapter implements
        CreatePersistenceAdapter<Castle>,
        DeletePersistenceAdapter<Castle>,
        FetchAllPersistenceAdapter<Castle>,
        FetchByIdPersistenceAdapter<Castle>,
        UpdatePersistenceAdapter<Castle> {
    private Long nextId = 1L;
    private Map<Long, Castle> repository = new ConcurrentHashMap<>(10);
}
