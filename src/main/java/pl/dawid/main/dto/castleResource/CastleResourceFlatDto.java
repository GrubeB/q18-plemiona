package pl.dawid.main.dto.castleResource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.main.dto.root.GDto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CastleResourceFlatDto extends GDto {
    private Long amount;
    private String title;
}
