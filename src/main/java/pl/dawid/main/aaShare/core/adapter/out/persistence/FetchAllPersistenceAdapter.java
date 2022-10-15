package pl.dawid.main.aaShare.core.adapter.out.persistence;

import pl.dawid.main.aaShare.core.application.port.out.FetchAllPort;
import pl.dawid.main.aaShare.core.application.port.out.GetRepositoryPort;
import pl.dawid.main.aaShare.core.domain.SetId;

import java.util.ArrayList;
import java.util.List;

public interface FetchAllPersistenceAdapter<T extends SetId> extends GetRepositoryPort<T>, FetchAllPort<T> {

    @Override
    default List<T> fetchAll() {
        return new ArrayList<>(getRepository().values());
    }
}
