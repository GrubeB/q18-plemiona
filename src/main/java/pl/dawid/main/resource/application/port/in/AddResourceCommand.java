package pl.dawid.main.resource.application.port.in;

import lombok.Getter;
import pl.dawid.main.aaShare.SelfValidating;

import javax.validation.constraints.Positive;

@Getter
public class AddResourceCommand extends SelfValidating<AddResourceCommand> {
    @Positive
    private Long amount;
}
