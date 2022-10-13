package pl.dawid.main.resource.application.port.out;

import pl.dawid.main.resource.domain.CastleResource;

import java.util.List;

public interface FetchAllCastleResourcePort {
    List<CastleResource> fetchAll();
}
