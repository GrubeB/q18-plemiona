package pl.dawid.main.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.main.entity.root.GEntity;

import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@NoArgsConstructor
//@Entity
//@Table(name = "table_test")
public class Test extends GEntity<Long> {
    private String title;
    private String description;
}
