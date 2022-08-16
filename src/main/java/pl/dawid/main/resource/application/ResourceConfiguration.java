package pl.dawid.main.resource.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.dawid.main.resource.adapter.out.persistence.ResourceEntityCommand;
import pl.dawid.main.resource.adapter.out.persistence.ResourcePersistenceAdapter;
import pl.dawid.main.resource.application.service.CreateResourceService;
import pl.dawid.main.resource.application.service.FetchResourceService;
import pl.dawid.main.resource.application.service.UpdateResourceService;

@Configuration
public class ResourceConfiguration {

    /* HELPERS */

    @Bean
    ResourceFactory resourceFactory() {
        return new ResourceFactory();
    }

    /* ADAPTERS */

    @Bean
    ResourcePersistenceAdapter resourcePersistenceAdapter(ResourceEntityCommand resourceEntityCommand) {
        return new ResourcePersistenceAdapter(resourceEntityCommand);
    }

    /* SERVICES */

    @Bean
    CreateResourceService createResourceService(
            ResourcePersistenceAdapter resourcePersistenceAdapter,
            ResourceFactory resourceFactory
    ) {
        return new CreateResourceService(
                resourcePersistenceAdapter,
                resourceFactory
        );
    }

    @Bean
    FetchResourceService fetchResourceService(
            ResourcePersistenceAdapter resourcePersistenceAdapter
    ) {
        return new FetchResourceService(
                resourcePersistenceAdapter
        );
    }

    @Bean
    UpdateResourceService updateResourceService(
            ResourcePersistenceAdapter resourcePersistenceAdapter
    ) {
        return new UpdateResourceService(
                resourcePersistenceAdapter,
                resourcePersistenceAdapter
        );
    }

}
