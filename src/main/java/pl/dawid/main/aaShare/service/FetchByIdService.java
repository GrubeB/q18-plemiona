package pl.dawid.main.aaShare.service;

import pl.dawid.main.aaShare.persistence.FetchByIdPort;
import pl.dawid.main.aaShare.persistence.SetId;

public interface FetchByIdService<T extends SetId> extends FetchByIdUseCase<T> {

    @Override
    default T fetchById(Long id) {
        return getFetchByIdPort().fetchById(id);
    }

    FetchByIdPort<T> getFetchByIdPort();
}
