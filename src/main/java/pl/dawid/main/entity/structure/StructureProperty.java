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
//@Table(name = "table_structure_property")
public class StructureProperty extends GEntity<Long> {

    private String name;
    private Float value;
    @ManyToOne
    @JoinColumn(name="structure_level_id", referencedColumnName = "id",nullable = false)
    private StructureLevel structureLevel;
}