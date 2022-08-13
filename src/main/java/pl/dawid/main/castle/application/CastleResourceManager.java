package pl.dawid.main.castle.application;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import pl.dawid.main.castle.application.port.out.FetchCastlePort;
import pl.dawid.main.castle.application.port.out.FetchCastleResourcePort;
import pl.dawid.main.castle.application.port.out.UpdateCastleResourcePort;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.castle.domain.CastleResource;

import java.util.List;

@RequiredArgsConstructor
public class CastleResourceManager {

    private static final Logger logger = LoggerFactory.getLogger(CastleResourceManager.class);
    private static final Integer FIXED_DELAY = 1000;

    private final FetchCastlePort fetchCastlePort;
    private final FetchCastleResourcePort fetchCastleResourcePort;

    private final UpdateCastleResourcePort updateCastleResourcePort;

    @Scheduled(fixedRate = 10000)
    private void castlesResourceAutoUpdate() {
        logger.info("castlesResourceAutoUpdate");
        List<CastleResource> castleResourceList = fetchCastleResourcePort.findAll();
        castleResourceList.forEach((castleResource)-> {
                    castleResource.autoUpdate();
                    updateCastleResourcePort.updateEntity(castleResource);
                }
        );
    }
}
