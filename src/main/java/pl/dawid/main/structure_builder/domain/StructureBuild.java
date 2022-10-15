package pl.dawid.main.structure_builder.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.main.aaShare.core.domain.SetId;
import pl.dawid.main.structure.domain.Structure;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StructureBuild implements SetId {
    private Long id;
    private Structure structure;
    private LocalDateTime createdDataTime;
    private LocalDateTime endDataTime;
}
