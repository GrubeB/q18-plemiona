package pl.dawid.main.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dawid.main.service.TestService;

//@RestController
@Getter
@AllArgsConstructor
//@RequestMapping("/test")
public class TestControllerImpl implements TestController {
    private TestService service;
}
