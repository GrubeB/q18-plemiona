package pl.dawid.q13generic.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dawid.q13generic.entity.Test;
import pl.dawid.q13generic.service.TestService;

import java.util.List;

@RestController
@RequestMapping("/test")
@Getter
@AllArgsConstructor
public class TestControllerImpl implements TestController {
    private TestService service;
    //    @GetMapping("/page")
//    public ResponseEntity<List<Test>> fetchAll2(@RequestBody Test test, @RequestBody Page page) {
//        List<Test> dtoList = service.fetchEntityAll();
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(dtoList);
//    }
}
