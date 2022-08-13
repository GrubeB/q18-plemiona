package pl.dawid.main.service.root.entity.declaration;

public interface UpdateEntityServiceDeclaration<ENTITY, ID> {
    ENTITY updateEntity(ID id, ENTITY entity);
}
