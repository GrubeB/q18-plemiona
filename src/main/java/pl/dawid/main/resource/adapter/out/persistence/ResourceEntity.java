package pl.dawid.main.resource.adapter.out.persistence;

import lombok.*;
import org.hibernate.Hibernate;
import pl.dawid.main.resource.domain.ResourceType;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_castle_resource")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResourceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private Long amount;
    @Enumerated(EnumType.STRING)
    @Column(name = "resource_type")
    private ResourceType resourceType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ResourceEntity that = (ResourceEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
