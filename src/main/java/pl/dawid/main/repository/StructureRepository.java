package pl.dawid.main.repository;

import org.springframework.stereotype.Repository;
import pl.dawid.main.entity.structure.Structure;
import pl.dawid.main.repository.root.GRepository;

//@Repository
public interface StructureRepository extends GRepository<Structure, Long> {

}
