package pl.dawid.main.aaShare.core.application.port.out;

public interface UpdatePort<T> {
    T update(Long id, T jpaEntity);
}
