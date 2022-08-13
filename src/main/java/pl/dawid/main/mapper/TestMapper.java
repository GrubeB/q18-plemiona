package pl.dawid.main.mapper;

import org.mapstruct.Mapper;
import pl.dawid.main.entity.Test;
import pl.dawid.main.dto.TestCreateDto;
import pl.dawid.main.dto.TestDto;
import pl.dawid.main.dto.TestUpdateDto;
import pl.dawid.main.mapper.root.FullDtoMapper;
import pl.dawid.main.mapper.root.config.MapStructConfig;

//@Mapper(config = MapStructConfig.class)
public interface TestMapper extends
        FullDtoMapper<Test, TestDto, TestUpdateDto, TestCreateDto>
//        DtoMapper<Test, TestDto>,
//        UpdateDtoMapper<Test, TestUpdateDto>,
//        CreateDtoMapper<Test, TestCreateDto>
{
}
