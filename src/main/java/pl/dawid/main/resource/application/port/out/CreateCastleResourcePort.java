package pl.dawid.main.resource.application.port.out;

import pl.dawid.main.resource.domain.CastleResource;

public interface CreateCastleResourcePort {
    CastleResource create(CastleResource jpaEntity);
}
