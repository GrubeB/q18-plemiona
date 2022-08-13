package pl.dawid.main.service.root;

import pl.dawid.main.repository.root.GRepository;

public interface GService<ENTITY, ID> {
    GRepository<ENTITY, ID> getRepository();
}
