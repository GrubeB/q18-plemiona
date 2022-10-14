package pl.dawid.main;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.dawid.main.castle.application.port.in.CreateCastleCommand;
import pl.dawid.main.castle.application.port.in.CreateCastleUseCase;
import pl.dawid.main.castle.domain.Castle;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class test {
    private static final Logger logger = LoggerFactory.getLogger(test.class);
    private final CreateCastleUseCase createCastleUseCase;
    private Castle castle;

    @PostConstruct
    private void construct(){
        castle = createCastleUseCase.create(new CreateCastleCommand("Nowa"));
    }
    @Scheduled(initialDelay  = 100,fixedDelay = 1000)
    private void log() {
            logger.info(castle.getCastleResource().toString());
            logger.info(castle.getCastleStructure().toString());
    }
}
