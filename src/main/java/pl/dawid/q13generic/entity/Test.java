package pl.dawid.q13generic.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import pl.dawid.q13generic.entity.root.GEntity;

import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "table_test")
public class Test extends GEntity<Long> {
    private String title;
    private String description;
}
