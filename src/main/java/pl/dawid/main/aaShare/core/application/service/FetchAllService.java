package pl.dawid.main.aaShare.core.application.service;

import pl.dawid.main.aaShare.core.application.port.out.FetchAllPort;
import pl.dawid.main.aaShare.core.domain.SetId;
import pl.dawid.main.aaShare.core.application.port.in.FetchAllUseCase;

import java.util.List;

public interface FetchAllService<T extends SetId> extends
        FetchAllUseCase<T> {

    default List<T> fetchAll() {
        return getFetchAllPort().fetchAll();
    }

    FetchAllPort<T> getFetchAllPort();
}
