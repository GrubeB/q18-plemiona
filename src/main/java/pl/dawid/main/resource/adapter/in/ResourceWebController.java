package pl.dawid.main.resource.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dawid.main.resource.application.port.in.*;
import pl.dawid.main.resource.domain.Resource;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(ResourceWebController.resourceMapping)
public class ResourceWebController {
    public static final String resourceMapping = "/api/resource";
    private final ResourceDtoMapper resourceDtoMapper = ResourceDtoMapper.INSTANCE;
    private final CreateResourceUseCase createResourceUseCase;
    private final FetchResourceUseCase fetchResourceUseCase;
    private final AddResourceUseCase addResourceUseCase;
    private final SubtractResourceUseCase subtractResourceUseCase;


    @GetMapping("/{id}")
    ResponseEntity<ResourceDto> fetchById(@PathVariable Long id) {
        Resource resource = fetchResourceUseCase.findById(id);
        ResourceDto resourceDto = resourceDtoMapper.map(resource);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resourceDto);
    }

    @GetMapping
    ResponseEntity<List<ResourceDto>> fetchAll() {
        List<Resource> resourceList = fetchResourceUseCase.findAll();
        List<ResourceDto> resourceDtoList = resourceDtoMapper.map(resourceList);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resourceDtoList);
    }

    @PostMapping
    ResponseEntity<Void> create(@RequestBody CreateResourceCommand command) {
        createResourceUseCase.createResource(command);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PostMapping("/{id}/addResource")
    ResponseEntity<Void> addResource(@PathVariable("id") Long resourceId, @RequestBody AddResourceCommand command) {
        addResourceUseCase.addResource(resourceId, command);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PostMapping("/{id}/subtractResource")
    ResponseEntity<Void> subtractResource(@PathVariable("id") Long resourceId, @RequestBody SubtractResourceCommand command) {
        subtractResourceUseCase.subtractResource(resourceId, command);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
