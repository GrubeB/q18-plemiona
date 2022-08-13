package pl.dawid.main.castle.adapter.out.persistence.castle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface CastleEntityCommand{
    Optional<CastleEntity> findById(Long id);
    List<CastleEntity> findAll();
    List<CastleEntity> findByName(String name);
    CastleEntity saveAndFlush(CastleEntity castleEntity);
}
