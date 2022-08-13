package pl.dawid.main.dto.castle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.main.dto.castleResource.CastleResourceDto;
import pl.dawid.main.dto.root.GIdDto;
import pl.dawid.main.entity.structure.CastleStructure;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CastleDto extends GIdDto<Long> {
    private String name;
    private Long x;
    private Long y;
    private List<CastleResourceDto> castleResourceList;
    private List<CastleStructure> castleStructureList;
}