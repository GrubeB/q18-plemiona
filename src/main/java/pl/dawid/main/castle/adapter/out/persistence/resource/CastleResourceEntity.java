package pl.dawid.main.castle.adapter.out.persistence.resource;

import lombok.*;
import pl.dawid.main.castle.adapter.out.persistence.castle.CastleEntity;
import pl.dawid.main.castle.domain.CastleResource.ResourceType;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "castle_id", updatable = false)
    private CastleEntity castle;
    @Enumerated(EnumType.STRING)
    private ResourceType type;
    @Column(name="amount_per_second")
    private Double amountPerSecond;
    @Column(name="last_update")
    private LocalDateTime lastAutoUpdate;
}
