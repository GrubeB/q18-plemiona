package pl.dawid.main.resource.application.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.dawid.main.aaShare.SelfValidating;
import pl.dawid.main.resource.domain.BaseResource;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddResourceCommand extends SelfValidating<AddResourceCommand> {
    private List<BaseResource> resourceList;
}
