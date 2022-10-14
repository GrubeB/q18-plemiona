package pl.dawid.main.structure_builder.application.port.in;

import pl.dawid.main.structure_builder.application.port.in.dto.LevelUpStructureCommand;

public interface LevelUpStructurePort {
    void levelUpStructure(LevelUpStructureCommand command);
}
