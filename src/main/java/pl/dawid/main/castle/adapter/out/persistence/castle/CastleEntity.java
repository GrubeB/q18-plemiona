package pl.dawid.main.castle.adapter.out.persistence.castle;

import lombok.*;
import pl.dawid.main.castle.adapter.out.persistence.resource.CastleResourceEntity;

import javax.persistence.*;
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
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<CastleResourceEntity> castleResourceList;
}
