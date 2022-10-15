package pl.dawid.main.aaShare.persistence;

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
