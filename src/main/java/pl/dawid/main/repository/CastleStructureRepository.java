package pl.dawid.main.repository;

import org.springframework.stereotype.Repository;
import pl.dawid.main.entity.structure.CastleStructure;
import pl.dawid.main.repository.root.GRepository;

//@Repository
public interface CastleStructureRepository extends GRepository<CastleStructure, Long> {

}
