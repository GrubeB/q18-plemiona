package pl.dawid.q13generic.controller.root;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.dawid.q13generic.controller.root.declaration.DeleteControllerDeclaration;
import pl.dawid.q13generic.service.root.entity.DeleteEntityByIdService;

public interface DeleteController<ENTITY, ID> extends
        GController,
        DeleteControllerDeclaration<ID> {
    @DeleteMapping(byId)
    default void deleteById(@PathVariable ID id) {
        getService().deleteEntityById(id);
    }

    DeleteEntityByIdService<ENTITY, ID> getService();
}
