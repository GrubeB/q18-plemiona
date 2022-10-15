package pl.dawid.main.aaShare.core.application.port.in;

public interface FetchByIdUseCase<T> {
    T fetchById(Long id);
}
