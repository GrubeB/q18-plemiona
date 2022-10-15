package pl.dawid.main.aaShare.service;

public interface CreateUseCase<T, COMMAND> {
    T create(COMMAND command);
}
