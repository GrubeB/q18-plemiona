package pl.dawid.main.structureBlueprint.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StructureProperty {
    private Long id;
    private String name;
    private Float value;
}