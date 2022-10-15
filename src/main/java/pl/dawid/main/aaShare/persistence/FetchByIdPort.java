package pl.dawid.main.aaShare.persistence;

public interface FetchByIdPort<T> {
    T fetchById(Long id);
}
