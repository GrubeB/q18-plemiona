package pl.dawid.q13generic.service;

import pl.dawid.q13generic.entity.Test;
import pl.dawid.q13generic.dto.TestCreateDto;
import pl.dawid.q13generic.dto.TestDto;
import pl.dawid.q13generic.dto.TestUpdateDto;
import pl.dawid.q13generic.service.root.FullService;

public interface TestService extends
        FullService<Test, TestDto, TestUpdateDto, TestCreateDto, Long>
//        FetchService<Test, TestDto, Long>,
//        DeleteService<Test, Long>,
//        CreateService<Test, TestDto, TestCreateDto, Long>,
//        UpdateService<Test, TestDto, TestUpdateDto, Long>
{
}