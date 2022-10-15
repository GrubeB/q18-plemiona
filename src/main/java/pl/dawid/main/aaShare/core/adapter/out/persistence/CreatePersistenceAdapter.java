package pl.dawid.main.aaShare.core.adapter.out.persistence;

import pl.dawid.main.aaShare.core.application.port.out.CreatePort;
import pl.dawid.main.aaShare.core.application.port.out.GetRepositoryPort;
import pl.dawid.main.aaShare.core.domain.SetId;

public interface CreatePersistenceAdapter<T extends SetId> extends GetRepositoryPort<T>, CreatePort<T> {

    @Override
    default T create(T jpaEntity) {
        jpaEntity.setId(getNextId());
        getRepository().put(getNextId(), jpaEntity);
        setNextId(getNextId() + 1);
        return jpaEntity;
    }
}
