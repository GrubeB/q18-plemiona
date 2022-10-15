package pl.dawid.main.structure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.main.aaShare.core.domain.SetId;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.resource.domain.Resource;
import pl.dawid.main.resource.domain.ResourceType;
import pl.dawid.main.structure.domain.Structure;
import pl.dawid.main.structure_blueprint.domain.StructureType;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CastleStructure implements SetId {

    private Long id;

    private Castle castle;
    private Map<StructureType, Structure> structureMap;

    /* METHODS */

    public void verifyIfStructureIsNotBuilt(StructureType structureType) throws IllegalArgumentException {
        if (checkIfStructureIsBuilt(structureType)) {
            throw new IllegalArgumentException("Structure has been already built");
        }
    }
    public boolean checkIfStructureIsBuilt(StructureType structureType) {
        return structureMap.containsKey(structureType);
    }

    // ---------------------------------------------------------------------------------------------------------------

    public void setCastle(Castle newCastle) {
        if (castle == newCastle) return;
        castle.setCastleStructure(null);
        newCastle.getCastleStructure().setCastle(null);
        castle = newCastle;
        castle.setCastleStructure(this);
    }
    public void addStructureObject(Structure structure) {
        if (Objects.isNull(structureMap.get(structure.getStructureType()))) {
            structureMap.put(structure.getStructureType(), structure);
        }
        //throw TODO have to think about it
    }
    public void removeStructureObject(Structure structure) {
        structureMap.remove(structure.getStructureType());
    }

    public Map<StructureType, Structure> getStructureObjectList() {
        return Collections.unmodifiableMap(this.structureMap);
    }

    // ---------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        String log = structureMap.entrySet().stream()
                .map((e) -> "[" + e.getKey() + " " + e.getValue().getLevel() + "]")
                .reduce(" ", (v1, v2) -> v1 + " " + v2);
        return "CastleStructure{" + log + '}';
    }

}
