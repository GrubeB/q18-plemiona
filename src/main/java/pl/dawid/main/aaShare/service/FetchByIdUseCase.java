package pl.dawid.main.aaShare.service;

public interface FetchByIdUseCase<T> {
    T fetchById(Long id);
}
