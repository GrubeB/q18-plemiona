package pl.dawid.main.aaShare.core.application.port.in;

import java.util.List;

public interface FetchAllUseCase<T> {
    List<T> fetchAll();
}
