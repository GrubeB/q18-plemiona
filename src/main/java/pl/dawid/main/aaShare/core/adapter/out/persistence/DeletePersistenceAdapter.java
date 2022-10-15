package pl.dawid.main.aaShare.core.adapter.out.persistence;

import pl.dawid.main.aaShare.core.application.port.out.DeletePort;
import pl.dawid.main.aaShare.core.application.port.out.GetRepositoryPort;
import pl.dawid.main.aaShare.core.domain.SetId;

public interface DeletePersistenceAdapter<T extends SetId> extends GetRepositoryPort<T>, DeletePort {

    @Override
    default void delete(Long id) {
        getRepository().remove(id);
    }
}
