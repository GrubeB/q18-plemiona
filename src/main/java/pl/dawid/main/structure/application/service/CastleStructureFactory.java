package pl.dawid.main.structure.application.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.structure.CastleStructure;

import java.util.HashMap;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class CastleStructureFactory {
    public CastleStructure createCastleStructure(Castle castle) {
        CastleStructure castleStructure = new CastleStructure(null, castle, new HashMap<>(5));
        return castleStructure;
    }
}
