package pl.dawid.main.castle.adapter.out.persistence.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CastleResourceEntityCommandRepository extends
        CastleResourceEntityCommand,
        JpaRepository<CastleResourceEntity, Long> {
}
