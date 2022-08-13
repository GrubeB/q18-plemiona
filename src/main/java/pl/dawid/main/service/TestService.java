package pl.dawid.main.service;

import pl.dawid.main.entity.Test;
import pl.dawid.main.dto.TestCreateDto;
import pl.dawid.main.dto.TestDto;
import pl.dawid.main.dto.TestUpdateDto;
import pl.dawid.main.service.root.FullService;

public interface TestService extends
        FullService<Test, TestDto, TestUpdateDto, TestCreateDto, Long>
//        FetchService<Test, TestDto, Long>,
//        DeleteService<Test, Long>,
//        CreateService<Test, TestDto, TestCreateDto, Long>,
//        UpdateService<Test, TestDto, TestUpdateDto, Long>
{
}
