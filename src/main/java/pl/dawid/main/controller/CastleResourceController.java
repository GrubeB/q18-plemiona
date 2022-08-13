package pl.dawid.main.controller;


import pl.dawid.main.controller.root.*;
import pl.dawid.main.dto.castleResource.CastleResourceDto;
import pl.dawid.main.entity.resources.CastleResource;
import pl.dawid.main.service.CastleResourceService;

public interface CastleResourceController extends
        FetchController<CastleResource, CastleResourceDto, Long>
        //FullController<CastleResource, CastleResourceDto, CastleResourceDto, CastleResourceDto, Long>
{
    CastleResourceService getService();
}
