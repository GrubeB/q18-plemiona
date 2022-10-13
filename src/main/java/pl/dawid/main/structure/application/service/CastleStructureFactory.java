package pl.dawid.main.structure.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.resource.domain.CastleResource;
import pl.dawid.main.resource.domain.Resource;
import pl.dawid.main.resource.domain.ResourceType;
import pl.dawid.main.structure.CastleStructure;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CastleStructureFactory {
    public CastleStructure createCastleStructure(Castle castle) {
        CastleStructure castleStructure = new CastleStructure(null, castle, new HashMap<>(5));
        return castleStructure;
    }
}
