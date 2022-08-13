package pl.dawid.main.castle.adapter.out.persistence.castle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CastleEntityCommandRepository extends
        CastleEntityCommand,
        JpaRepository<CastleEntity, Long> {
}
