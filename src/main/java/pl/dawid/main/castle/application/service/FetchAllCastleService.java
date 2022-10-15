package pl.dawid.main.castle.application.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.dawid.main.castle.application.port.in.FetchAllCastleUseCase;
import pl.dawid.main.castle.application.port.out.FetchAllCastlePort;
import pl.dawid.main.castle.domain.Castle;

import java.util.List;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class FetchAllCastleService implements
        //FetchAllService<Castle>,
        FetchAllCastleUseCase {
    private final FetchAllCastlePort fetchAllPort;
    public List<Castle> fetchAll() {
        return getFetchAllPort().fetchAll();
    }
}
