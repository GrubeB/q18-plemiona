package pl.dawid.main.dto.castleResource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.main.dto.root.GDto;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CastleResourceFlatListDto extends GDto {
    private List<CastleResourceFlatDto> castleResources;
}
