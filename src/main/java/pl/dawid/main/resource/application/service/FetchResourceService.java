package pl.dawid.main.resource.application.service;

import lombok.RequiredArgsConstructor;
import pl.dawid.main.aaShare.NotFoundException;
import pl.dawid.main.resource.application.port.in.FetchResourceUseCase;
import pl.dawid.main.resource.application.port.out.FetchResourcePort;
import pl.dawid.main.resource.domain.Resource;

import java.util.List;

@RequiredArgsConstructor
public class FetchResourceService implements FetchResourceUseCase {

    private final FetchResourcePort fetchResourcePort;

    @Override
    public List<Resource> findAll() {
        return fetchResourcePort.findAll();
    }

    @Override
    public Resource findById(Long resourceId) {
        return fetchResourcePort.findById(resourceId)
                .orElseThrow(() -> new NotFoundException(resourceId));
    }
}
