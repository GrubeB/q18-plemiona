package pl.dawid.main.structure.tool;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.main.structure.domain.Structure;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StructureBuild {
    private Long id;

    private Structure structure;
    private LocalDateTime createdDataTime;
    private LocalDateTime endDataTime;
}
