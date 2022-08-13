package pl.dawid.main.repository.root;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GRepository<ENTITY, ID> extends
        JpaRepository<ENTITY, ID>,
        JpaSpecificationExecutor<ENTITY> {
}
