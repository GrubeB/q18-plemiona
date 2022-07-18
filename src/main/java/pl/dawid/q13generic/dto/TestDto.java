package pl.dawid.q13generic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.q13generic.dto.root.GIdDto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestDto extends GIdDto<Long> {
    private String title;
    private String description;
}