package pl.dawid.main.structure_builder.application.port.in;

import pl.dawid.main.structure_builder.application.port.in.dto.BuildStructureCommand;

public interface BuildStructurePort {
    void buildStructure(BuildStructureCommand command);
}
