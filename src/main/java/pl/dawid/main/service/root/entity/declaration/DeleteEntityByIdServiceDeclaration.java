package pl.dawid.main.service.root.entity.declaration;

public interface DeleteEntityByIdServiceDeclaration<ID, ENTITY> {
    void deleteEntityById(ID id);

    void beforeDeleteEntity(ID id, ENTITY existingEntity);

    void afterDeleteEntity(ID id);
}
