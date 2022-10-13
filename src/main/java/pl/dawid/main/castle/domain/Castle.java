package pl.dawid.main.castle.domain;

import lombok.*;
import pl.dawid.main.resource.domain.CastleResource;
import pl.dawid.main.structure.CastleStructure;

//@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Castle {
    private Long id;
    //private User user;//TODO when user module will be ready
    private String name;
    private CastleResource castleResource;
    private CastleStructure castleStructure;
    /* CONSTRUCTORS */
//    public static Castle castleWithId();
//    public static Castle castleWithoutId();

    /* METHODS */

//    public void addCastleResource(CastleResource castleResource){
//        if(castleResourceList.stream().anyMatch(r->r.getType().equals(castleResource.getType()))){
//            return;
//        }
//        castleResourceList.add(castleResource);
//        castleResource.setCastle(this);
//    }
//    public void removeCastleResource(CastleResource castleResource){
//        castleResourceList.remove(castleResource);
//        castleResource.setCastle(null);
//    }
//    public List<CastleResource> getCastleResourceList(){
//        return Collections.unmodifiableList(this.castleResourceList);
//    }

}
