package pl.dawid.main.resource.application.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dawid.main.aaShare.core.application.service.FetchAllService;
import pl.dawid.main.castle.application.port.in.FetchCastleByIdUseCase;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.resource.application.CastleResourceFactory;
import pl.dawid.main.resource.application.port.in.*;
import pl.dawid.main.resource.application.port.in.dto.AddResourceCommand;
import pl.dawid.main.resource.application.port.in.dto.CreateCastleResourceCommand;
import pl.dawid.main.resource.application.port.in.dto.SubtractResourceCommand;
import pl.dawid.main.resource.application.port.out.CreateCastleResourcePort;
import pl.dawid.main.resource.application.port.out.FetchAllCastleResourcePort;
import pl.dawid.main.resource.application.port.out.FetchCastleResourceByIdPort;
import pl.dawid.main.resource.application.port.out.UpdateCastleResourcePort;
import pl.dawid.main.resource.domain.CastleResource;

import java.util.List;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class FetchAllCastleResourceService implements
        FetchAllCastleResourceUseCase,
        FetchAllService<CastleResource> {
    private final FetchAllCastleResourcePort fetchAllPort;
}
