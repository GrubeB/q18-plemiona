package pl.dawid.main.castle.application.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.dawid.main.aaShare.service.FetchAllService;
import pl.dawid.main.aaShare.service.FetchByIdService;
import pl.dawid.main.castle.application.port.out.FetchAllCastlePort;
import pl.dawid.main.castle.application.port.out.FetchCastleByIdPort;
import pl.dawid.main.castle.domain.Castle;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class FetchCastleByIdService implements FetchByIdService<Castle> {
    private final FetchCastleByIdPort fetchByIdPort;
}
