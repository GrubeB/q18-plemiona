package pl.dawid.main.resource.adapter.in;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.dawid.main.resource.application.port.in.FetchAllCastleResourceUseCase;
import pl.dawid.main.resource.domain.CastleResource;


@Service
@RequiredArgsConstructor
public class CastleResourceAutoUpdateAdapter {
    private static final Logger logger = LoggerFactory.getLogger(CastleResourceAutoUpdateAdapter.class);

    private final FetchAllCastleResourceUseCase fetchAllCastleResourceUseCase;

    @Scheduled(initialDelay  = 110, fixedDelay = 1000)
    private void castlesResourceAutoUpdate() {
        logger.info("castlesResourceAutoUpdate");
        fetchAllCastleResourceUseCase.fetchAll()
                .forEach(CastleResource::autoUpdate);
    }
}
