package pl.dawid.main.castle.application.port.out;

import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.castle.domain.CastleResource;

public interface UpdateCastleResourcePort {
    CastleResource updateEntity(CastleResource castleResource);
}
