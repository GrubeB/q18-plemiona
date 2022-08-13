package pl.dawid.main.controller;


import pl.dawid.main.controller.root.FullController;
import pl.dawid.main.entity.Test;
import pl.dawid.main.dto.TestCreateDto;
import pl.dawid.main.dto.TestDto;
import pl.dawid.main.dto.TestUpdateDto;
import pl.dawid.main.service.TestService;

public interface TestController extends
        FullController<Test, TestDto, TestUpdateDto, TestCreateDto, Long>
//        FetchController<Test, TestDto, Long>,
//        DeleteController<Test, Long>,
//        UpdateController<Test, TestDto, TestUpdateDto, Long>,
//        CreateController<Test, TestDto, TestCreateDto, Long>
{
    TestService getService();
}
