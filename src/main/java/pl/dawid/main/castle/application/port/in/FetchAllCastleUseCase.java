package pl.dawid.main.castle.application.port.in;

import pl.dawid.main.castle.domain.Castle;

import java.util.List;

public interface FetchAllCastleUseCase {
    List<Castle> findAll();
}
