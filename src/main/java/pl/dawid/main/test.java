package pl.dawid.main;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.resource.application.port.in.dto.CreateCastleResourceCommand;
import pl.dawid.main.resource.application.port.in.CreateCastleResourceUseCase;
import pl.dawid.main.resource.domain.CastleResource;
import pl.dawid.main.structure.CastleStructure;
import pl.dawid.main.structure.application.port.in.CreateCastleStructurePort;
import pl.dawid.main.structure.application.port.in.dto.CreateCastleStructureCommand;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class test {
    private static final Logger logger = LoggerFactory.getLogger(test.class);
    private final CreateCastleResourceUseCase createCastleResourceUseCase;
    private final CreateCastleStructurePort createCastleStructurePort;
    private Castle castle;

    @PostConstruct
    private void construct(){
        castle = new Castle();
        CastleResource castleResource = createCastleResourceUseCase.createCastleResource(new CreateCastleResourceCommand(castle));
        castle.setCastleResource(castleResource);
        CastleStructure castleStructure = createCastleStructurePort.createCastleStructure(new CreateCastleStructureCommand(castle));
        castle.setCastleStructure(castleStructure);

    }
    @Scheduled(initialDelay  = 100,fixedDelay = 1000)
    private void log() {
            logger.info(castle.getCastleResource().toString());
            logger.info(castle.getCastleStructure().toString());
    }
}
