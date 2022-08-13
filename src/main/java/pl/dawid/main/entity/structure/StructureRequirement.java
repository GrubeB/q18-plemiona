package pl.dawid.main.entity.structure;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.main.entity.root.GEntity;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
//@Entity
//@Table(name = "table_structure_requirement")
public class StructureRequirement extends GEntity<Long> {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="structure_id", referencedColumnName = "id",nullable = false)
    private Structure structure;

    private Integer level;


    @ManyToOne
    @JoinColumn(name="structure_level_id", referencedColumnName = "id",nullable = false)
    private StructureLevel structureLevel;
}