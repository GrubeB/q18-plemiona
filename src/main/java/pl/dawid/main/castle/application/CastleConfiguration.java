package pl.dawid.main.castle.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.dawid.main.castle.adapter.out.persistence.castle.CastleEntityCommand;
import pl.dawid.main.castle.adapter.out.persistence.CastlePersistenceAdapter;
import pl.dawid.main.castle.adapter.out.persistence.resource.CastleResourceEntityCommand;
import pl.dawid.main.castle.application.port.in.CreateCastleUseCase;

@Configuration
public class CastleConfiguration {
//    private final CastleEntityMapper castleEntityMapper;
//
//    public CastleConfiguration(CastleEntityMapper castleEntityMapper) {
//        this.castleEntityMapper = castleEntityMapper;
//    }

    @Bean
    CastlePersistenceAdapter createCastlePersistenceAdapter(CastleEntityCommand castleEntityCommand,
                                                            CastleResourceEntityCommand castleResourceEntityCommand) {
        return new CastlePersistenceAdapter(castleEntityCommand,
                castleResourceEntityCommand);
    }

    @Bean
    CreateCastleUseCase createCreateCastleUseCase(CastlePersistenceAdapter castlePersistenceAdapter) {
        return new CreateCastleService(castlePersistenceAdapter);
    }
}
