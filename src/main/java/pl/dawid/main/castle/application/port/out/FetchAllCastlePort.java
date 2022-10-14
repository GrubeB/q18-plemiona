package pl.dawid.main.castle.application.port.out;

import pl.dawid.main.castle.domain.Castle;

import java.util.List;
import java.util.Optional;

public interface FetchAllCastlePort {
    List<Castle> fetchAll();
}
