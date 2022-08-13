package pl.dawid.main.dto.castleResource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.main.dto.resource.ResourceDto;
import pl.dawid.main.dto.root.GIdDto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CastleResourceDto extends GIdDto<Long> {
    private Long amount;
    private ResourceDto resource;
}
