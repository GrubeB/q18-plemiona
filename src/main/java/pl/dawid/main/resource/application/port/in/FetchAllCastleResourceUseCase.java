package pl.dawid.main.resource.application.port.in;


import pl.dawid.main.resource.domain.CastleResource;

import java.util.List;

public interface FetchAllCastleResourceUseCase {
    List<CastleResource> fetchAll();

}
