package pl.dawid.main.castle.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class Castle {
    private Long id;
    //private User user;//TODO when user module will be ready
    private String name;
    private List<CastleResource> castleResourceList;

    /* CONSTRUCTORS */

    public Castle() {
        this.castleResourceList = new ArrayList<>();
    }

    public Castle(Long id, String name) {
        this.id = id;
        this.name = name;
        this.castleResourceList = new ArrayList<>();
    }
    //public static Castle castleWithId();
    //public static Castle castleWithoutId();
    /* METHODS */

    public void addCastleResource(CastleResource castleResource){
        if(castleResourceList.stream().anyMatch(r->r.getType().equals(castleResource.getType()))){
            return;
        }
        castleResourceList.add(castleResource);
        castleResource.setCastle(this);
    }
    public void removeCastleResource(CastleResource castleResource){
        castleResourceList.remove(castleResource);
        castleResource.setCastle(null);
    }
    public List<CastleResource> getCastleResourceList(){
        return Collections.unmodifiableList(this.castleResourceList);
    }

}
