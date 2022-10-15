package pl.dawid.main.aaShare.persistence;

public interface DeletePersistenceAdapter<T extends SetId> extends GetRepositoryPort<T>, DeletePort {

    @Override
    default void delete(Long id) {
        getRepository().remove(id);
    }
}
