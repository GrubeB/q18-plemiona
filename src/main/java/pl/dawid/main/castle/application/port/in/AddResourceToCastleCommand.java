package pl.dawid.main.castle.application.port.in;

import lombok.Getter;
import pl.dawid.main.castle.domain.CastleResource.ResourceType;

import java.util.List;

@Getter
public class AddResourceToCastleCommand {
    List<Resource> resourceList;
    @Getter
    public static class Resource {
        private Long amount;
        private ResourceType type;
    }
}
