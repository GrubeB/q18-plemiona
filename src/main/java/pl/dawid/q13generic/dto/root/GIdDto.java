package pl.dawid.q13generic.dto.root;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GIdDto<ID> extends GDto {
    private ID id;
}
