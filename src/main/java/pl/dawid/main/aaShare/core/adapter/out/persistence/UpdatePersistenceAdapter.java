package pl.dawid.main.aaShare.core.adapter.out.persistence;

import pl.dawid.main.aaShare.core.application.port.out.GetRepositoryPort;
import pl.dawid.main.aaShare.core.application.port.out.UpdatePort;
import pl.dawid.main.aaShare.core.domain.SetId;

import java.util.Optional;

public interface UpdatePersistenceAdapter<T extends SetId> extends GetRepositoryPort<T>, UpdatePort<T> {

    @Override
    default T update(Long id, T jpaEntity){
        T t = Optional.ofNullable(getRepository().get(id))
                .orElseThrow(() -> new RuntimeException("Not found object with id: " + id));
        getRepository().put(id, jpaEntity);
        return jpaEntity;
    }
    
}
