package pl.dawid.main.resource.application.port.in;


import pl.dawid.main.resource.domain.Resource;

import java.util.List;

public interface FetchResourceUseCase {
    List<Resource> findAll();

    Resource findById(Long resourceId);
}
