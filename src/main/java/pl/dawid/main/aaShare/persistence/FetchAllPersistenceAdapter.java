package pl.dawid.main.aaShare.persistence;

import java.util.ArrayList;
import java.util.List;

public interface FetchAllPersistenceAdapter<T extends SetId> extends GetRepositoryPort<T>, FetchAllPort<T> {

    @Override
    default List<T> fetchAll() {
        return new ArrayList<>(getRepository().values());
    }
}
