package pl.dawid.main.service.root.entity.declaration;

public interface FetchEntityByIdServiceDeclaration<ENTITY, ID> {
    ENTITY fetchEntityById(ID id);
    void beforeFetchEntityById(ID id);
    void afterFetchEntityById(ID id,ENTITY entity);
}
