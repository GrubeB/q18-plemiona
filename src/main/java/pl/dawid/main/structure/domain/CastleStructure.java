package pl.dawid.main.structure;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Castle castle;
    private Map<StructureType, Structure> structureMap;

    /* METHODS */

    public void verifyIfStructureIsNotBuilt(StructureType structureType) throws IllegalArgumentException {
        if (checkIfStructureIsBuilt(structureType)) {
            throw new IllegalArgumentException("Structure has been already built");
        }
    }
    public void verifyIfStructureIsBuilt(StructureType structureType) throws IllegalArgumentException {
        if (!checkIfStructureIsBuilt(structureType)) {
            throw new IllegalArgumentException("Structure has been already built");
        }
    }

    public boolean checkIfStructureIsBuilt(StructureType structureType) {
        return structureMap.containsKey(structureType);
    }

    public void levelUpStructure(StructureType structureType) {
        Structure structure = structureMap.get(structureType);
        if(structure == null) throw new RuntimeException("Not fount object");
        structure.setNextLevel();
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

    @JsonIgnore
    public Map<StructureType, Structure> getStructureObjectMap() {
        return Collections.unmodifiableMap(this.structureMap);
    }

    public Structure getStructureObjectByStructureType(StructureType structureType) {
        return structureMap.get(structureType);
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
