package pl.dawid.q13generic.service.root.entity.declaration;

public interface UpdateEntityServiceDeclaration<ENTITY, ID> {
    ENTITY updateEntity(ID id, ENTITY entity);
}
