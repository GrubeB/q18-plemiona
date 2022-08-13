package pl.dawid.main.repository;

import org.springframework.stereotype.Repository;
import pl.dawid.main.entity.Test;
import pl.dawid.main.repository.root.GRepository;

//@Repository
public interface TestRepository extends GRepository<Test, Long> {

}
