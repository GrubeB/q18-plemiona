package pl.dawid.main.castle.application.port.out;

import pl.dawid.main.castle.domain.Castle;

public interface UpdateCastlePort {
    Castle update(Long id, Castle jpaEntity);
}
