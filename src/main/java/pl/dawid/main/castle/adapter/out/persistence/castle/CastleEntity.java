package pl.dawid.main.castle.adapter.out.persistence.castle;

import lombok.*;
import pl.dawid.main.castle.adapter.out.persistence.resource.CastleResourceEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_castle")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CastleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    //private User user;//TODO when user module will be ready
    private String name;
    @OneToMany(mappedBy = "castle",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    private List<CastleResourceEntity> castleResourceList = new ArrayList<>();
    public void addCastleResourceEntity(CastleResourceEntity castleResourceEntity){
        castleResourceList.add(castleResourceEntity);
        castleResourceEntity.setCastle(this);
    }
    public void removeCastleResourceEntity(CastleResourceEntity castleResourceEntity){
        castleResourceList.remove(castleResourceEntity);
        castleResourceEntity.setCastle(null);
    }
}
