package pl.dawid.main.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dawid.main.service.CastleResourceService;

//@RestController
@Getter
@AllArgsConstructor
//@RequestMapping(CastleResourceControllerImpl.resourceMapping)
public class CastleResourceControllerImpl implements CastleResourceController {
    public static final String resourceMapping = "/castle_resources";
    private CastleResourceService service;
}
