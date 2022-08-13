package pl.dawid.main.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import pl.dawid.main.entity.resources.Resource;
import pl.dawid.main.entity.resources.ResourceType;
import pl.dawid.main.exception.NotFoundException;
import pl.dawid.main.mapper.ResourceMapper;
import pl.dawid.main.repository.ResourceRepository;

//@Service
@Getter
@AllArgsConstructor
public class ResourceServiceImpl implements ResourceService {
    private ResourceRepository repository;
    private ResourceMapper mapper;
    private ResourceMapper createMapper;
    private ResourceMapper updateMapper;

    public Resource getResourceByType(ResourceType type){
        return repository.findByTitle(type.name)
                .orElseThrow(()->new NotFoundException("Not found object with type: "+type.name)); //TODO
    }
}
