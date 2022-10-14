package pl.dawid.main.structure_blueprint.adapter.in;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.dawid.main.structure_blueprint.application.port.out.CreateStructureBlueprintPort;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class StructureBlueprintAutoInit {
    /**
     * IT WILL BE REMOVED AND REPLACED WITH LIQUIBASE
     */
    private static final Logger logger = LoggerFactory.getLogger(StructureBlueprintAutoInit.class);

    private final CreateStructureBlueprintPort createStructureBlueprintPort;

    @PostConstruct
    private void init(){
        logger.info("StructureBlueprintAutoInit - init()");
        IronMine ironMine = new IronMine();
        createStructureBlueprintPort.create(ironMine);
    }
}
