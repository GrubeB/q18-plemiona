package pl.dawid.main.resource.application.port.in;


import pl.dawid.main.resource.application.port.in.dto.AddResourceCommand;

public interface AddResourceUseCase {
    void addResource(Long castleResourceId, AddResourceCommand command);
}
