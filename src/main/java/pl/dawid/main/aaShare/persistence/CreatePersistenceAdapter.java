package pl.dawid.main.aaShare.persistence;

public interface CreatePersistenceAdapter<T extends SetId> extends GetRepositoryPort<T>, CreatePort<T> {

    @Override
    default T create(T jpaEntity) {
        setNextId(getNextId() + 1);
        jpaEntity.setId(getNextId());
        getRepository().put(getNextId(), jpaEntity);
        return jpaEntity;
    }
}
