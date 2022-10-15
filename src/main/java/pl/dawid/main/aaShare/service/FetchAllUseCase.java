package pl.dawid.main.aaShare.service;

import java.util.List;

public interface FetchAllUseCase<T> {
    List<T> fetchAll();
}
