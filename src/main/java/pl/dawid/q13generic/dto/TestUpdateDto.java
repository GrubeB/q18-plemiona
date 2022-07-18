package pl.dawid.q13generic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.q13generic.dto.root.GDto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestUpdateDto extends GDto {
    private String title;
    private String description;
}
