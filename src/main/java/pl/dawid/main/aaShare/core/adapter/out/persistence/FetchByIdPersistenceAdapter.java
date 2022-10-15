package pl.dawid.main.aaShare.core.adapter.out.persistence;

import pl.dawid.main.aaShare.core.application.port.out.FetchByIdPort;
import pl.dawid.main.aaShare.core.application.port.out.GetRepositoryPort;
import pl.dawid.main.aaShare.core.domain.SetId;

import java.util.Optional;

public interface FetchByIdPersistenceAdapter<T extends SetId> extends GetRepositoryPort<T>, FetchByIdPort<T> {

    @Override
    default T fetchById(Long id) {
        return Optional.ofNullable(getRepository().get(id)).orElseThrow(() -> new RuntimeException("Not found object with id: " + id));
    }

}
