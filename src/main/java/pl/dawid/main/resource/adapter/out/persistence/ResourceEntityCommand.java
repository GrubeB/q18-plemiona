package pl.dawid.main.resource.adapter.out.persistence;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.dawid.main.resource.domain.ResourceType;

import java.util.List;
import java.util.Optional;

public interface ResourceEntityCommand {
    Optional<ResourceEntity> findById(Long id);

    List<ResourceEntity> findAll();

    List<ResourceEntity> findAllByResourceType(ResourceType resourceType);

    ResourceEntity saveAndFlush(ResourceEntity resourceEntity);

    @Modifying
    @Query(value = "UPDATE ResourceEntity r SET r.amount=amount+:amount WHERE r.id=:id")
    void updateAddResourceAmount(@Param("id") Long id, @Param("amount") Long amount);

    @Modifying
    @Query(value = "UPDATE ResourceEntity r SET r.amount=amount-:amount WHERE r.id=:id")
    void updateSubtractResourceAmount(@Param("id") Long id, @Param("amount") Long amount);

    boolean existsById(Long id);
}
