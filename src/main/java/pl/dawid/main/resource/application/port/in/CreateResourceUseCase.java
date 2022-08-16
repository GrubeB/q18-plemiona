package pl.dawid.main.resource.application.port.in;


import pl.dawid.main.resource.domain.Resource;

public interface CreateResourceUseCase {
    Resource createResource(CreateResourceCommand command);
}
