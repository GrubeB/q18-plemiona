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
//@Table(name = "table_castle_structure_build")
public class CastleStructureBuild extends GEntity<Long> {
    private Integer order;// form 0

//    @Column(name="level_from")
//    private Integer levelFrom;
//    @Column(name="level_to")
//    private Integer levelTo;
//    @Column(name="start_time")
//    private LocalDateTime startTime;
//    @Column(name="end_time")
//    private LocalDateTime endTime;
//
//    @ManyToOne
//    @JoinColumn(
//            name="castle_id",
//            referencedColumnName = "id",
//            nullable = false
//    )
//    private Castle castle;
//
//    @ManyToOne
//    @JoinColumn(
//            name="castle_structure_id",
//            referencedColumnName = "id",
//            nullable = false
//    )
//    private CastleStructure castleStructure;
}
