package pl.dawid.q13generic.service.root.entity.declaration;

public interface FetchEntityByIdServiceDeclaration<ENTITY, ID> {
    ENTITY fetchEntityById(ID id);
}
