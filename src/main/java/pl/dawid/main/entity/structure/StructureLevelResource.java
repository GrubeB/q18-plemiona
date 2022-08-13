package pl.dawid.main.entity.structure;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.main.entity.resources.Resource;
import pl.dawid.main.entity.root.GEntity;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
//Entity
//@Table(name = "table_structure_level_resource")
public class StructureLevelResource extends GEntity<Long> {
    private Long amount;
    @ManyToOne
    @JoinColumn(
            name = "structure_level_id",
            referencedColumnName = "id",
            nullable = false
    )
    private StructureLevel structureLevel;

    @ManyToOne
    @JoinColumn(
            name = "resource_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Resource resource;

    public StructureLevelResource(Long amount, StructureLevel structureLevel, Resource resource) {
        this.amount = amount;
        this.structureLevel = structureLevel;
        this.resource = resource;
    }
}