package pl.dawid.main.castle.application;

import lombok.RequiredArgsConstructor;
import pl.dawid.main.aaShare.NotFoundException;
import pl.dawid.main.castle.application.port.in.FetchAllCastleUseCase;
import pl.dawid.main.castle.application.port.in.FetchCastleByIdUseCase;
import pl.dawid.main.castle.application.port.out.FetchCastlePort;
import pl.dawid.main.castle.domain.Castle;

import java.util.List;

@RequiredArgsConstructor
public class FetchCastleService implements
        FetchCastleByIdUseCase,
        FetchAllCastleUseCase {

    private final FetchCastlePort fetchCastlePort;

    @Override
    public Castle findById(Long id) {
        return fetchCastlePort.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public List<Castle> findAll() {
        return fetchCastlePort.findAll();
    }
}
