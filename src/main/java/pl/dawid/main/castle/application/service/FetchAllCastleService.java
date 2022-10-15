package pl.dawid.main.castle.application.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.dawid.main.aaShare.core.application.service.FetchAllService;
import pl.dawid.main.castle.application.port.in.FetchAllCastleUseCase;
import pl.dawid.main.castle.application.port.out.FetchAllCastlePort;
import pl.dawid.main.castle.domain.Castle;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class FetchAllCastleService implements
        FetchAllCastleUseCase,
        FetchAllService<Castle> {
    private final FetchAllCastlePort fetchAllPort;
}
