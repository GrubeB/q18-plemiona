package pl.dawid.main.dto.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.main.dto.root.GIdDto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDto extends GIdDto<Long> {
    private String title;
    private String description;
}