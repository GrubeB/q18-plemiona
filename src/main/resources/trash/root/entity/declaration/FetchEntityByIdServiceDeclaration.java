package pl.dawid.main.service.root.entity.declaration;

public interface FetchEntityByIdServiceDeclaration<ENTITY, ID> {
    ENTITY fetchEntityById(ID id);
}
