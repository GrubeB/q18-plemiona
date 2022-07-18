package pl.dawid.q13generic.repository;

import org.springframework.stereotype.Repository;
import pl.dawid.q13generic.entity.Test;
import pl.dawid.q13generic.repository.root.GRepository;

@Repository
public interface TestRepository extends GRepository<Test, Long> {

}
