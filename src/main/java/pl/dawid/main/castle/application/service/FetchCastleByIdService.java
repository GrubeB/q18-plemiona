package pl.dawid.main.castle.application.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.dawid.main.aaShare.service.FetchAllService;
import pl.dawid.main.aaShare.service.FetchByIdService;
import pl.dawid.main.castle.application.port.in.FetchCastleByIdUseCase;
import pl.dawid.main.castle.application.port.out.FetchAllCastlePort;
import pl.dawid.main.castle.application.port.out.FetchCastleByIdPort;
import pl.dawid.main.castle.domain.Castle;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class FetchCastleByIdService implements
        // FetchByIdService<Castle>,
        FetchCastleByIdUseCase
{
    private final FetchCastleByIdPort fetchByIdPort;


    public Castle fetchById(Long id) {
        return getFetchByIdPort().fetchById(id);
    }
}
