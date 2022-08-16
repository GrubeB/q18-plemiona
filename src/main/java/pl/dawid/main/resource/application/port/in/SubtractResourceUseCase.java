package pl.dawid.main.resource.application.port.in;


public interface SubtractResourceUseCase {
    void subtractResource(Long resourceId, SubtractResourceCommand command);
}
