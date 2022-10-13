package pl.dawid.main.resource.application.port.in.dto;

import lombok.Getter;
import pl.dawid.main.aaShare.SelfValidating;
import pl.dawid.main.resource.domain.BaseResource;

import java.util.List;

@Getter
public class AddResourceCommand extends SelfValidating<AddResourceCommand> {
    private List<BaseResource> resourceList;
}
