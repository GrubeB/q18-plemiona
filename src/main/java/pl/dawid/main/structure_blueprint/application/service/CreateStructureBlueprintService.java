package pl.dawid.main.structure_blueprint.application.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.dawid.main.structure_blueprint.application.port.in.CreateStructureBlueprintCommand;
import pl.dawid.main.structure_blueprint.application.port.in.CreateStructureBlueprintUseCase;
import pl.dawid.main.structure_blueprint.application.port.out.CreateStructureBlueprintPort;
import pl.dawid.main.structure_blueprint.application.port.out.FetchStructureBlueprintByStructureTypePort;
import pl.dawid.main.structure_blueprint.domain.StructureBlueprint;
import pl.dawid.main.structure_blueprint.domain.StructureType;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class CreateStructureBlueprintService implements
        CreateStructureBlueprintUseCase {
    private final CreateStructureBlueprintPort createStructureBlueprintPort;

    @Override
    public StructureBlueprint create(CreateStructureBlueprintCommand createStructureBlueprintCommand) {
        return createStructureBlueprintPort.create(createStructureBlueprintCommand.getStructureBlueprint());
    }
}
