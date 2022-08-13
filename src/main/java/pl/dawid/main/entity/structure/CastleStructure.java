package pl.dawid.main.entity.structure;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.main.entity.castle.Castle;
import pl.dawid.main.entity.root.GEntity;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
//@Entity
//@Table(name = "table_castle_structure")
public class CastleStructure extends GEntity<Long> {
    private Integer level;

    @ManyToOne
    @JoinColumn(
            name="castle_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Castle castle;

    @ManyToOne
    @JoinColumn(
            name="structure_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Structure structure;
}
