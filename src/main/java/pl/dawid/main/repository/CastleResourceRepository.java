package pl.dawid.main.repository;

import org.springframework.stereotype.Repository;
import pl.dawid.main.entity.resources.CastleResource;
import pl.dawid.main.repository.root.GRepository;

//@Repository
public interface CastleResourceRepository extends GRepository<CastleResource, Long> {

}
