package pl.dawid.main.structure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.main.aaShare.persistence.SetId;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.structure.domain.Structure;
import pl.dawid.main.structure_blueprint.domain.StructureType;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CastleStructure implements SetId {

    private Long id;

    private Castle castle;
    private Map<StructureType, Structure> structureMap;

    /* METHODS */
    public void setCastle(Castle newCastle) {
        if (castle == newCastle) return;
        castle.setCastleStructure(null);
        newCastle.getCastleStructure().setCastle(null);
        castle = newCastle;
        castle.setCastleStructure(this);
    }

    public boolean getIfStructureExists(StructureType structureType) {
        return structureMap.containsKey(structureType);
    }

    @Override
    public String toString() {
        String log = structureMap.entrySet().stream()
                .map((e) -> "[" + e.getKey() + " " + e.getValue().getLevel() + "]")
                .reduce(" ", (v1, v2) -> v1 + " " + v2);
        return "CastleStructure{" + log + '}';
    }

}
