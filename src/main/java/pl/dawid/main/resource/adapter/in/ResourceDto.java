package pl.dawid.main.resource.adapter.in;

import lombok.Getter;
import lombok.Setter;
import pl.dawid.main.resource.domain.ResourceType;

import java.io.Serializable;

@Setter
@Getter
public class ResourceDto implements Serializable {
    private Long id;
    private Long amount;
    private ResourceType resourceType;
}
