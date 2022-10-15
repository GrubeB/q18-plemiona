package pl.dawid.main.aaShare.persistence;

import java.util.List;

public interface FetchAllPort<T> {
    List<T> fetchAll();
}
