package pl.dawid.main.aaShare.core.application.service;

import pl.dawid.main.aaShare.core.application.port.out.FetchByIdPort;
import pl.dawid.main.aaShare.core.domain.SetId;
import pl.dawid.main.aaShare.core.application.port.in.FetchByIdUseCase;

public interface FetchByIdService<T extends SetId> extends
        FetchByIdUseCase<T> {

    default T fetchById(Long id) {
        return getFetchByIdPort().fetchById(id);
    }

    FetchByIdPort<T> getFetchByIdPort();
}
