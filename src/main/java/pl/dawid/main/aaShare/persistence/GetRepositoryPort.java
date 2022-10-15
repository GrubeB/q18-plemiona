package pl.dawid.main.aaShare.persistence;

import java.util.Map;

public interface GetRepositoryPort<T> {
    Map<Long, T> getRepository();
    Long getNextId();
    void setNextId(Long id);
}
