package pl.dawid.main.castle.application.port.out;

import pl.dawid.main.castle.domain.Castle;

public interface CreateCastlePort {
    Castle createEntity(Castle castle);
}
