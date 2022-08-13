package pl.dawid.main.castle.adapter.out.persistence.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dawid.main.castle.adapter.out.persistence.castle.CastleEntity;

import java.util.List;
import java.util.Optional;

public interface CastleResourceEntityCommand{
    Optional<CastleResourceEntity> findById(Long id);
    List<CastleResourceEntity> findAll();
    CastleResourceEntity saveAndFlush(CastleResourceEntity castleResourceEntity);
}
