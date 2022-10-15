package pl.dawid.main.aaShare.core.application.port.out;

import java.util.List;

public interface FetchAllPort<T> {
    List<T> fetchAll();
}
