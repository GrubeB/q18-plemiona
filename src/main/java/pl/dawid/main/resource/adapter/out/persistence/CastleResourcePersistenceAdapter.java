package pl.dawid.main.resource.adapter.out.persistence;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.dawid.main.aaShare.core.adapter.out.persistence.*;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.resource.application.port.out.*;
import pl.dawid.main.resource.domain.CastleResource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class CastleResourcePersistenceAdapter implements
        CreateCastleResourcePort,
        DeleteCasteResourcePort,
        FetchCastleResourceByIdPort,
        FetchAllCastleResourcePort,
        UpdateCastleResourcePort,
        CreatePersistenceAdapter<CastleResource>,
        DeletePersistenceAdapter<CastleResource>,
        FetchAllPersistenceAdapter<CastleResource>,
        FetchByIdPersistenceAdapter<CastleResource>,
        UpdatePersistenceAdapter<CastleResource> {
    private Long nextId = 1L;
    private Map<Long, CastleResource> repository = new ConcurrentHashMap<>(10);

}
