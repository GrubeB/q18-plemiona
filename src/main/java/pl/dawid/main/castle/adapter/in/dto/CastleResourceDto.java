package pl.dawid.main.castle.adapter.in.dto;

import lombok.Getter;
import lombok.Setter;
import pl.dawid.main.castle.domain.CastleResource.ResourceType;

@Getter
@Setter
public class CastleResourceDto {
    private Long id;
    private Long amount;
    private Long amountMax;
    private ResourceType type;
}
