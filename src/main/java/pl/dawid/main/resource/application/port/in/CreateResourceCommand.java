package pl.dawid.main.resource.application.port.in;

import lombok.Getter;
import pl.dawid.main.aaShare.SelfValidating;
import pl.dawid.main.resource.domain.ResourceType;

@Getter
public class CreateResourceCommand extends SelfValidating<CreateResourceCommand> {
    private ResourceType resourceType;
}
