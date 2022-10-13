package pl.dawid.main.resource.application.port.in;


import pl.dawid.main.resource.application.port.in.dto.SubtractResourceCommand;

public interface SubtractResourceUseCase {
    void subtractResource(Long castleResourceId, SubtractResourceCommand command);
}
