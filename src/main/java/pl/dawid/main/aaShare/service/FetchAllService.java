package pl.dawid.main.aaShare.service;

import pl.dawid.main.aaShare.persistence.FetchAllPersistenceAdapter;
import pl.dawid.main.aaShare.persistence.FetchAllPort;
import pl.dawid.main.aaShare.persistence.GetRepositoryPort;
import pl.dawid.main.aaShare.persistence.SetId;
import pl.dawid.main.castle.domain.Castle;

import java.util.ArrayList;
import java.util.List;

public interface FetchAllService<T extends SetId> extends FetchAllUseCase<T> {

    @Override
    default List<T> fetchAll() {
        return getFetchAllPort().fetchAll();
    }

    FetchAllPort<T> getFetchAllPort();
}
