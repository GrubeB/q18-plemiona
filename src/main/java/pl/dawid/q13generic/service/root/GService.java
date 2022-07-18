package pl.dawid.q13generic.service.root;

import pl.dawid.q13generic.repository.root.GRepository;

public interface GService<ENTITY, ID> {
    GRepository<ENTITY, ID> getRepository();
}
