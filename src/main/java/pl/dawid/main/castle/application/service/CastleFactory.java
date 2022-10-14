package pl.dawid.main.castle.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.resource.application.port.in.CreateCastleResourceUseCase;
import pl.dawid.main.resource.application.port.in.dto.CreateCastleResourceCommand;
import pl.dawid.main.resource.domain.CastleResource;
import pl.dawid.main.resource.domain.Resource;
import pl.dawid.main.resource.domain.ResourceType;
import pl.dawid.main.structure.CastleStructure;
import pl.dawid.main.structure.application.port.in.CreateCastleStructurePort;
import pl.dawid.main.structure.application.port.in.dto.CreateCastleStructureCommand;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CastleFactory {

    public Castle createCastle(String name) {
        Castle castle = new Castle();
        castle.setName(name);
        return castle;
    }
}
