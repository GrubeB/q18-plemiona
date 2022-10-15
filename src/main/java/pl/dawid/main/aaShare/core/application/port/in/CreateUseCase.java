package pl.dawid.main.aaShare.core.application.port.in;

public interface CreateUseCase<T, COMMAND> {
    T create(COMMAND command);
}
