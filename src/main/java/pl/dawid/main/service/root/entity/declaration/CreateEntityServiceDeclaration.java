package pl.dawid.main.service.root.entity.declaration;

public interface CreateEntityServiceDeclaration<ENTITY> {
    ENTITY createEntity(ENTITY entity);
    void beforeCreateEntity(ENTITY entity);
    void afterCreateEntity(ENTITY savedEntity);
}
