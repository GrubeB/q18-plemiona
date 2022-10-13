package pl.dawid.main.resource.application.port.in.dto;

import lombok.Getter;
import lombok.Setter;
import pl.dawid.main.aaShare.SelfValidating;
import pl.dawid.main.resource.domain.ResourceType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class BaseResourceDTO extends SelfValidating<BaseResourceDTO> {
    @Positive
    private Long amount;
    @NotNull
    private ResourceType resourceType;

    public BaseResourceDTO() {
    }

    public BaseResourceDTO(Long amount, ResourceType resourceType) {
        this.amount = amount;
        this.resourceType = resourceType;
    }
}
