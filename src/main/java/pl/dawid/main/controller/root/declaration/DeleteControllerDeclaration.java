package pl.dawid.main.controller.root.declaration;

import org.springframework.web.bind.annotation.PathVariable;

public interface DeleteControllerDeclaration<ID> {
    void deleteById(@PathVariable ID id);
}
