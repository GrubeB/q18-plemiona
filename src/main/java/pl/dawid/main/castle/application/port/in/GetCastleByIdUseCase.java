package pl.dawid.main.castle.application.port.in;

import pl.dawid.main.castle.domain.Castle;

import java.util.Collection;

public interface GetCastleByIdUseCase {
    Collection<Castle> findAll();
}
