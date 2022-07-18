package pl.dawid.q13generic.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import pl.dawid.q13generic.mapper.TestMapper;
import pl.dawid.q13generic.repository.TestRepository;

@Service
@Getter
@AllArgsConstructor
public class TestServiceImpl implements TestService {
    private TestRepository repository;
    private TestMapper mapper;
    private TestMapper createMapper;
    private TestMapper updateMapper;
}
