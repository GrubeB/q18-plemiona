package pl.dawid.main.castle.application.port.in;

import pl.dawid.main.castle.domain.Castle;

import java.util.Collection;
import java.util.Optional;

public interface GetAllCastleUseCase {
    Optional<Castle> findById(Long id);
}
