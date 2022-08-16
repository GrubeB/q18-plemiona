package pl.dawid.main.resource.application.service;

import lombok.RequiredArgsConstructor;
import pl.dawid.main.aaShare.NotFoundException;
import pl.dawid.main.resource.application.port.in.AddResourceCommand;
import pl.dawid.main.resource.application.port.in.AddResourceUseCase;
import pl.dawid.main.resource.application.port.in.SubtractResourceCommand;
import pl.dawid.main.resource.application.port.in.SubtractResourceUseCase;
import pl.dawid.main.resource.application.port.out.FetchResourcePort;
import pl.dawid.main.resource.application.port.out.UpdateResourcePort;
import pl.dawid.main.resource.domain.Resource;

import javax.transaction.Transactional;

@RequiredArgsConstructor
public class UpdateResourceService implements
        AddResourceUseCase,
        SubtractResourceUseCase {

    private final UpdateResourcePort updateResourcePort;
    private final FetchResourcePort fetchResourcePort;

    @Override
    @Transactional
    public void addResource(Long resourceId, AddResourceCommand command) {
        Resource resource = fetchResourcePort.findById(resourceId)
                .orElseThrow(() -> new NotFoundException(resourceId));
        updateResourcePort.updateAddResourceAmount(resourceId, command.getAmount());
//        Resource resource = fetchResourcePort.findById(resourceId)
//                .orElseThrow(()->new NotFoundException(resourceId));
//        resource.addResource(command.getAmount());
//        updateResourcePort.updateEntity(resource);
    }

    @Override
    @Transactional
    public void subtractResource(Long resourceId, SubtractResourceCommand command) {
        Resource resource = fetchResourcePort.findById(resourceId)
                .orElseThrow(() -> new NotFoundException(resourceId));
        resource.checkIfSubtractPossible(command.getAmount());
        updateResourcePort.updateSubtractResourceAmount(resourceId, command.getAmount());
    }
}
