package pl.dawid.main.castle.application.port.out;

import pl.dawid.main.castle.domain.Castle;

import java.util.List;
import java.util.Optional;

public interface FetchCastlePort {
    Optional<Castle> findById(Long id);
    List<Castle> findByName(String name);

    List<Castle> findAll();
}
