package pl.dawid.main.castle.application.port.out;

import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.castle.domain.CastleResource;

import java.util.List;
import java.util.Optional;

public interface FetchCastleResourcePort {
    Optional<CastleResource> findById(Long id);
    List<CastleResource> findAll();
}
