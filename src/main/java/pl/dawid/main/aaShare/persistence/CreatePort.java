package pl.dawid.main.aaShare.persistence;

public interface CreatePort<T> {
    T create(T jpaEntity);
}
