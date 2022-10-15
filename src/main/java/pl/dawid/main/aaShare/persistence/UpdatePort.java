package pl.dawid.main.aaShare.persistence;

public interface UpdatePort<T> {
    T update(Long id, T jpaEntity);
}
