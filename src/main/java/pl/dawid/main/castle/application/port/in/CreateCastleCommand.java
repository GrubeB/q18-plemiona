package pl.dawid.main.castle.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.dawid.main.aaShare.SelfValidating;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCastleCommand extends SelfValidating<CreateCastleCommand> {
    @NotBlank
    private String name;
}
