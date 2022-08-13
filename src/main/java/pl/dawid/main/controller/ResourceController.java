package pl.dawid.main.controller;


import pl.dawid.main.controller.root.FullController;
import pl.dawid.main.dto.resource.ResourceDto;
import pl.dawid.main.entity.resources.Resource;
import pl.dawid.main.service.ResourceService;

public interface ResourceController extends
        FullController<Resource, ResourceDto, ResourceDto, ResourceDto, Long> {
    ResourceService getService();
}
