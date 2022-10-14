package pl.dawid.main.resource.application.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.main.aaShare.SelfValidating;
import pl.dawid.main.resource.domain.ResourceType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResourceDTO extends SelfValidating<BaseResourceDTO> {
    @Positive
    private Long amount;
    @NotNull
    private ResourceType resourceType;
}
