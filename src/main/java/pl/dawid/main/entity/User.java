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
//@Table(name = "table_user")
public class User extends GEntity<Long> {
    private String name;
}
