package pl.dawid.main.resource.application.port.in;


import pl.dawid.main.resource.domain.CastleResource;

import java.util.List;

public interface FetchCastleResourceUseCase {
    List<CastleResource> findAllCastleResource();

    CastleResource findCastleResourceById(Long castleResourceId);
}
