package pl.dawid.main.castle.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.dawid.main.castle.adapter.out.persistence.CastlePersistenceAdapter;
import pl.dawid.main.castle.adapter.out.persistence.castle.CastleEntityCommand;
import pl.dawid.main.castle.adapter.out.persistence.resource.CastleResourceEntityCommand;
import pl.dawid.main.castle.application.port.in.CreateCastleUseCase;

@Configuration
public class CastleConfiguration {
    @Bean
    CastlePersistenceAdapter createCastlePersistenceAdapter(CastleEntityCommand castleEntityCommand,
                                                            CastleResourceEntityCommand castleResourceEntityCommand) {
        return new CastlePersistenceAdapter(castleEntityCommand, castleResourceEntityCommand);
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
