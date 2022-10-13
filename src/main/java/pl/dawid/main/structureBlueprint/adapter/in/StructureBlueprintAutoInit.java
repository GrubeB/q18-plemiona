package pl.dawid.main.structureBlueprint.adapter.in;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.dawid.main.resource.adapter.in.CastleResourceAutoUpdateAdapter;
import pl.dawid.main.structureBlueprint.application.port.out.CreatePort;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class StructureBlueprintAutoInit {
    /**
     * IT WILL BE REMOVED AND REPLACED WITH LIQUIBASE
     */
    private static final Logger logger = LoggerFactory.getLogger(StructureBlueprintAutoInit.class);

    private final CreatePort createPort;

    @PostConstruct
    private void init(){
        logger.info("StructureBlueprintAutoInit - init()");
        IronMine ironMine = new IronMine();
        createPort.create(ironMine);
    }
}
