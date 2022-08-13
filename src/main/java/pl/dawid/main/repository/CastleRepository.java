package pl.dawid.main.repository;

import org.springframework.stereotype.Repository;
import pl.dawid.main.entity.castle.Castle;
import pl.dawid.main.repository.root.GRepository;

//@Repository
public interface CastleRepository extends GRepository<Castle, Long> {

}
