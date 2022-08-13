package pl.dawid.main.entity.resources;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.main.entity.root.GEntity;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
//@Entity
//@Table(name = "table_resource")
public class Resource extends GEntity<Long> implements Serializable {

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ResourceType type;
    private String title;
    private String description;

    public Resource(ResourceType type) {
        this.type = type;
        this.title = type.name;
        this.description = type.description;
    }
}
