package pl.dawid.main.aaShare.persistence;

import java.util.Optional;

public interface FetchByIdPersistenceAdapter<T extends SetId> extends GetRepositoryPort<T>, FetchByIdPort<T> {

    @Override
    default T fetchById(Long id) {
        return Optional.ofNullable(getRepository().get(id)).orElseThrow(() -> new RuntimeException("Not found object with id: " + id));
    }

}
