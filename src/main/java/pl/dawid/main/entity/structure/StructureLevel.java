package pl.dawid.main.entity.structure;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.main.entity.root.GEntity;

import javax.persistence.*;
import java.time.Duration;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//@Entity
//@Table(name = "table_structure_level")
public class StructureLevel extends GEntity<Long> {

    private Integer level;

    private Duration duration;

    @ManyToOne
    @JoinColumn(
            name="structure_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Structure structure;

    @OneToMany(
            mappedBy = "structureLevel",
            cascade = CascadeType.ALL
    )
    private List<StructureLevelResource> structureLevelResourceList;

    @OneToMany(
            mappedBy = "structureLevel",
            cascade = CascadeType.PERSIST
    )
    private List<StructureProperty> structurePropertyList;

    @OneToMany(
            mappedBy = "structureLevel",
            cascade = CascadeType.PERSIST
    )
    private List<StructureRequirement> structureRequirementList;

    public StructureLevel(Integer level, Duration duration, Structure structure, List<StructureLevelResource> structureLevelResourceList, List<StructureProperty> structurePropertyList, List<StructureRequirement> structureRequirementList) {
        this.level = level;
        this.duration = duration;
        this.structure = structure;
        this.structureLevelResourceList = structureLevelResourceList;
        this.structurePropertyList = structurePropertyList;
        this.structureRequirementList = structureRequirementList;
    }

    public StructureLevel(Integer level, Duration duration, Structure structure) {
        this.level = level;
        this.duration = duration;
        this.structure = structure;
    }
}