package pl.dawid.main.aaShare.core.application.port.out;

public interface CreatePort<T> {
    T create(T jpaEntity);
}
