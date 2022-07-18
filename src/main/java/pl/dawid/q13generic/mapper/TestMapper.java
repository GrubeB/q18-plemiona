package pl.dawid.q13generic.mapper;

import org.mapstruct.Mapper;
import pl.dawid.q13generic.entity.Test;
import pl.dawid.q13generic.dto.TestCreateDto;
import pl.dawid.q13generic.dto.TestDto;
import pl.dawid.q13generic.dto.TestUpdateDto;
import pl.dawid.q13generic.mapper.root.FullDtoMapper;
import pl.dawid.q13generic.mapper.root.config.MapStructConfig;

@Mapper(config = MapStructConfig.class)
public interface TestMapper extends
        FullDtoMapper<Test, TestDto, TestUpdateDto, TestCreateDto>
//        DtoMapper<Test, TestDto>,
//        UpdateDtoMapper<Test, TestUpdateDto>,
//        CreateDtoMapper<Test, TestCreateDto>
{
}
