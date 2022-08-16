package pl.dawid.main.resource.application.service;

import lombok.RequiredArgsConstructor;
import pl.dawid.main.resource.application.ResourceFactory;
import pl.dawid.main.resource.application.port.in.CreateResourceCommand;
import pl.dawid.main.resource.application.port.in.CreateResourceUseCase;
import pl.dawid.main.resource.application.port.out.CreateResourcePort;
import pl.dawid.main.resource.domain.Resource;

@RequiredArgsConstructor
public class CreateResourceService implements CreateResourceUseCase {

    private final CreateResourcePort createResourcePort;
    private final ResourceFactory resourceFactory;

    @Override
    public Resource createResource(CreateResourceCommand command) {
        Resource resource = resourceFactory.createBaseResource(command.getResourceType());
        Resource resourceCreated = createResourcePort.createEntity(resource);
        return resourceCreated;
    }
}
