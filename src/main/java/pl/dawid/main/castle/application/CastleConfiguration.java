package pl.dawid.main.castle.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import pl.dawid.main.castle.adapter.out.persistence.CastlePersistenceAdapter;
import pl.dawid.main.castle.adapter.out.persistence.CastleResourcePersistenceAdapter;
import pl.dawid.main.castle.adapter.out.persistence.castle.CastleEntityCommand;
import pl.dawid.main.castle.adapter.out.persistence.resource.CastleResourceEntityCommand;
import pl.dawid.main.castle.application.port.in.CreateCastleUseCase;

@Configuration
@EnableScheduling
public class CastleConfiguration {
    @Bean
    CastlePersistenceAdapter createCastlePersistenceAdapter(CastleEntityCommand castleEntityCommand,
                                                            CastleResourceEntityCommand castleResourceEntityCommand) {
        return new CastlePersistenceAdapter(castleEntityCommand, castleResourceEntityCommand);
    }
    @Bean
    CastleResourcePersistenceAdapter castleResourcePersistenceAdapter(CastleResourceEntityCommand castleResourceEntityCommand) {
        return new CastleResourcePersistenceAdapter( castleResourceEntityCommand);
    }

    /* UseCase */
    @Bean
    CreateCastleUseCase createCreateCastleUseCase(CastlePersistenceAdapter castlePersistenceAdapter,
                                                  CastleValidator castleValidator,
                                                  CastleFactory castleFactory) {
        return new CreateCastleService(castlePersistenceAdapter, castleFactory, castleValidator);
    }

    @Bean
    FetchCastleService fetchCastleByIdCastleService(CastlePersistenceAdapter castlePersistenceAdapter) {
        return new FetchCastleService(castlePersistenceAdapter);
    }
    /* Managers */
    @Bean
    CastleResourceManager castleResourceSchedule(CastlePersistenceAdapter castlePersistenceAdapter) {
        return new CastleResourceManager(castlePersistenceAdapter);
    }
    /* Helpers */
    @Bean
    CastleValidator castleValidator(CastlePersistenceAdapter castlePersistenceAdapter) {
        return new CastleValidator(castlePersistenceAdapter);
    }

    @Bean
    CastleFactory castleFactory() {
        return new CastleFactory();
    }
}
