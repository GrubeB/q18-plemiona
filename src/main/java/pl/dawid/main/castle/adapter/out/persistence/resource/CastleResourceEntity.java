package pl.dawid.main.castle.adapter.out.persistence.resource;

import lombok.*;
import pl.dawid.main.castle.adapter.out.persistence.castle.CastleEntity;
import pl.dawid.main.castle.domain.CastleResource.ResourceType;

import javax.persistence.*;

@Entity
@Table(name = "t_castle_resource")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CastleResourceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private Long amount;
    private Long amountMax;
    @ManyToOne
    private CastleEntity castle;
    @Enumerated(EnumType.STRING)
    private ResourceType type;
}
