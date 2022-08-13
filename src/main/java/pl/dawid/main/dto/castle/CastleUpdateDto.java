package pl.dawid.main.dto.castle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.main.dto.root.GIdDto;
import pl.dawid.main.entity.resources.CastleResource;
import pl.dawid.main.entity.structure.CastleStructure;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CastleUpdateDto extends GIdDto<Long> {
    private String name;
    private Long x;
    private Long y;
    private List<CastleResource> castleResourceList;
    private List<CastleStructure> castleStructureList;
}