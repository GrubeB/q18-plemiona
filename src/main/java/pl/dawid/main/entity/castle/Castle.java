package pl.dawid.main.entity.castle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import pl.dawid.main.entity.resources.CastleResource;
import pl.dawid.main.entity.root.GEntity;
import pl.dawid.main.entity.structure.CastleStructure;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//@Entity
//@Table(name = "table_castle")
@SuperBuilder
public class Castle extends GEntity<Long> implements Serializable {

    //private User owner;
    private String name;
    private Long x;
    private Long y;

    @OneToMany(mappedBy = "castle",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<CastleResource> castleResourceList;


    @OneToMany(mappedBy = "castle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CastleStructure> castleStructureList;

    public Castle(String name, Long x, Long y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
}