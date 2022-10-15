package pl.dawid.main.castle.application.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.dawid.main.aaShare.core.application.service.FetchByIdService;
import pl.dawid.main.castle.application.port.in.FetchCastleByIdUseCase;
import pl.dawid.main.castle.application.port.out.FetchCastleByIdPort;
import pl.dawid.main.castle.domain.Castle;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class FetchCastleByIdService implements
        FetchCastleByIdUseCase,
        FetchByIdService<Castle> {
    private final FetchCastleByIdPort fetchByIdPort;
}
