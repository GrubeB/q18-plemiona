package pl.dawid.main.structure_builder.application.port.in;

import pl.dawid.main.structure_builder.application.port.in.dto.BuildStructureCommand;

public interface BuildStructureUseCase {
    void buildStructure(BuildStructureCommand command);
}
