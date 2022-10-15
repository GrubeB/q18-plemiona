package pl.dawid.main.aaShare.core.application.port.out;

public interface FetchByIdPort<T> {
    T fetchById(Long id);
}
