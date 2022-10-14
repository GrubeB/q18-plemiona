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
        newCastleResource.setCastle(null);
        castleResource = newCastleResource;
        castleResource.setCastle(this);
    }

    public void setCastleStructure(CastleStructure newCastleStructure) {
        newCastleStructure.setCastle(null);
        castleStructure = newCastleStructure;
        castleStructure.setCastle(this);
    }

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
