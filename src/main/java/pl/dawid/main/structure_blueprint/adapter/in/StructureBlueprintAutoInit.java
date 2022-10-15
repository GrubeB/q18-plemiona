package pl.dawid.main.structure_blueprint.adapter.in;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.dawid.main.structure_blueprint.application.port.in.CreateStructureBlueprintCommand;
import pl.dawid.main.structure_blueprint.application.port.in.CreateStructureBlueprintUseCase;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class StructureBlueprintAutoInit {
    /**
     * IT WILL BE REMOVED AND REPLACED WITH LIQUIBASE
     */
    private static final Logger logger = LoggerFactory.getLogger(StructureBlueprintAutoInit.class);

    private final CreateStructureBlueprintUseCase createStructureBlueprintUseCase;

    @PostConstruct
    private void init(){
        logger.info("StructureBlueprintAutoInit - init()");
        IronMine ironMine = new IronMine();
        createStructureBlueprintUseCase.create(new CreateStructureBlueprintCommand(ironMine));
    }
}
