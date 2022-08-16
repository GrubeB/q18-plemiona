package pl.dawid.main.resource.application.port.in;


public interface AddResourceUseCase {
    void addResource(Long resourceId, AddResourceCommand command);
}
