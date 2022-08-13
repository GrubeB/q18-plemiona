package pl.dawid.main.repository;

import org.springframework.stereotype.Repository;
import pl.dawid.main.entity.resources.Resource;
import pl.dawid.main.repository.root.GRepository;

import java.util.Optional;

//@Repository
public interface ResourceRepository extends GRepository<Resource, Long> {
    Optional<Resource> findByTitle(String title);
}
