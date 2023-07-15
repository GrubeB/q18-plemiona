package pl.dawid.main.structure.application;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.structure.CastleStructure;
import pl.dawid.main.structure.domain.Structure;
import pl.dawid.main.structure_blueprint.domain.StructureLevelType;
import pl.dawid.main.structure_blueprint.domain.StructureType;

import java.util.HashMap;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class CastleStructureFactory {
    public CastleStructure createCastleStructure(Castle castle) {
        return new CastleStructure(null, castle, new HashMap<>(5));
    }

    public Structure createStructure(StructureType structureType, CastleStructure castleStructure) {
        return new Structure(null, StructureLevelType.LEVEL0,castleStructure,structureType);
    }
}
