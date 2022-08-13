package pl.dawid.main.castle.application;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import pl.dawid.main.castle.application.port.out.FetchCastlePort;
import pl.dawid.main.castle.domain.Castle;

import java.util.List;

@RequiredArgsConstructor
public class CastleResourceManager {

    private static final Logger logger = LoggerFactory.getLogger(CastleResourceManager.class);
    private static final Integer FIXED_DELAY = 1000;

    private static final String CASTLE_NAME_MUST_BE_UNIQUE = "CASTLE_NAME_MUST_BE_UNIQUE";

    private final FetchCastlePort fetchCastlePort;

    @Scheduled(fixedRate = 1000)
    private void castlesResourceAutoUpdate() {
        logger.info("castlesResourceAutoUpdate");
        List<Castle> castleList = fetchCastlePort.findAll();

    }
}
