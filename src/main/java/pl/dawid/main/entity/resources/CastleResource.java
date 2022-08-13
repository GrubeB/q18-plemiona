package pl.dawid.main.entity.resources;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import pl.dawid.main.entity.castle.Castle;
import pl.dawid.main.entity.root.GEntity;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
//@Entity
//@Table(name = "table_castle_resource")
@SuperBuilder
public class CastleResource extends GEntity<Long> implements Serializable {
    private Long amount;

    @ManyToOne
    @JoinColumn(
            name = "castle_id",
            referencedColumnName = "id",
            nullable=false
    )
    private Castle castle;
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "resource_id",
            referencedColumnName = "id",
            nullable=false
    )
    private Resource resource;

    public CastleResource(Castle castle, Resource resource, Long amount) {
        this.castle = castle;
        this.resource = resource;
        this.amount = amount;
    }

    public void addAmount(Long amount){
        this.amount+=amount;
    }
    public void subtractAmount(Long amount){
        this.amount-=amount;
    }
}