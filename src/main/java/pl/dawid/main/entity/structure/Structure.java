package pl.dawid.main.entity.structure;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.main.entity.root.GEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//@Entity
//@Table(name = "table_structure")
public class Structure extends GEntity<Long> {
    private String name;
    private String description;
    private Integer levelMax;

    @OneToMany(
            mappedBy = "structure",
            cascade = CascadeType.ALL
    )
    private List<StructureLevel> structureLevelList;

    public Structure(StructureType type) {
        this.name = type.name;
        this.description = type.description;
        this.levelMax = type.levelMax;
    }
}
