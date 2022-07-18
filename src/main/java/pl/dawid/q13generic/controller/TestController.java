package pl.dawid.q13generic.controller;


import pl.dawid.q13generic.controller.root.FetchByCriteriaController;
import pl.dawid.q13generic.controller.root.FullController;
import pl.dawid.q13generic.entity.Test;
import pl.dawid.q13generic.dto.TestCreateDto;
import pl.dawid.q13generic.dto.TestDto;
import pl.dawid.q13generic.dto.TestUpdateDto;
import pl.dawid.q13generic.service.TestService;

public interface TestController extends
        FullController<Test, TestDto, TestUpdateDto, TestCreateDto, Long>
//        FetchController<Test, TestDto, Long>,
//        DeleteController<Test, Long>,
//        UpdateController<Test, TestDto, TestUpdateDto, Long>,
//        CreateController<Test, TestDto, TestCreateDto, Long>
{
    TestService getService();
}
