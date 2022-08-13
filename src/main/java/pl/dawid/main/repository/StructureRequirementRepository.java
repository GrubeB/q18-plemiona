package pl.dawid.main.repository;

import org.springframework.stereotype.Repository;
import pl.dawid.main.entity.structure.StructureRequirement;
import pl.dawid.main.repository.root.GRepository;

//@Repository
public interface StructureRequirementRepository extends GRepository<StructureRequirement, Long> {

}
