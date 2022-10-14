package pl.dawid.main.structure_blueprint.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StructureRequirement {
    private Long id;
    private Integer level;
    private StructureType structureType;
}