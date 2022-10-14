package pl.dawid.main.castle.domain;

import lombok.*;
import pl.dawid.main.resource.domain.CastleResource;
import pl.dawid.main.structure.CastleStructure;

//@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Castle {
    @Setter
    private Long id;
    //private User user;//TODO when user module will be ready
    @Setter
    private String name;
    private CastleResource castleResource;
    private CastleStructure castleStructure;

    /* METHODS */

    public void setCastleResource(CastleResource newCastleResource) {
        if (castleResource == newCastleResource) return;
        castleResource = newCastleResource;
    }

    public void setCastleStructure(CastleStructure newCastleStructure) {
        if (castleStructure == newCastleStructure) return;
        castleStructure = newCastleStructure;
    }

}
