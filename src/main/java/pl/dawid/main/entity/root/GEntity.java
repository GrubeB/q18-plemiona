package pl.dawid.main.entity.root;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder(builderMethodName = "baseBuilder")
public class GEntity<ID> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private ID id;
}
