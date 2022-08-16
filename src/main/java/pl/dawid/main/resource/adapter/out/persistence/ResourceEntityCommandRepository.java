package pl.dawid.main.resource.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceEntityCommandRepository extends
        ResourceEntityCommand,
        JpaRepository<ResourceEntity, Long> {
}
