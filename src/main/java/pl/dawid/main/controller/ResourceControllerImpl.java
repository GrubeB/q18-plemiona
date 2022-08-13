package pl.dawid.main.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dawid.main.service.ResourceService;

//@RestController
@Getter
@AllArgsConstructor
//@RequestMapping(ResourceControllerImpl.resourceMapping)
public class ResourceControllerImpl implements ResourceController {
    public static final String resourceMapping = "/resources";
    private ResourceService service;
}
