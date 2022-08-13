package pl.dawid.main.castle.application.port.out;

import pl.dawid.main.castle.domain.Castle;

import java.util.List;

public interface LoadCastlePort {
    Castle findById(Long id);

    List<Castle> findAll();
}
