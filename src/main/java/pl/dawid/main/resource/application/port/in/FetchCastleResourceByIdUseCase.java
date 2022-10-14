package pl.dawid.main.resource.application.port.in;


import pl.dawid.main.resource.domain.CastleResource;

public interface FetchCastleResourceByIdUseCase {

    CastleResource findById(Long id);
}
