package pl.dawid.main.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import pl.dawid.main.mapper.TestMapper;
import pl.dawid.main.repository.TestRepository;

//@Service
@Getter
@AllArgsConstructor
public class TestServiceImpl implements TestService {
    private TestRepository repository;
    private TestMapper mapper;
    private TestMapper createMapper;
    private TestMapper updateMapper;
}
