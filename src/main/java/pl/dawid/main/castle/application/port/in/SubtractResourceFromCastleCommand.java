package pl.dawid.main.castle.application.port.in;

import lombok.Getter;
import pl.dawid.main.castle.domain.CastleResource;

import java.util.List;

@Getter
public class SubtractResourceFromCastleCommand {
    List<Resource> resourceList;

    @Getter
    public static class Resource {
        private Long amount;
        private CastleResource.ResourceType type;
    }
}
