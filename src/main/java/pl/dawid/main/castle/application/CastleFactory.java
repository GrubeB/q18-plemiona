package pl.dawid.main.castle.application;

import lombok.RequiredArgsConstructor;
import pl.dawid.main.aaShare.NotFoundException;
import pl.dawid.main.castle.application.port.in.FetchAllCastleUseCase;
import pl.dawid.main.castle.application.port.in.FetchCastleByIdUseCase;
import pl.dawid.main.castle.application.port.out.FetchCastlePort;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.castle.domain.CastleResource;

import java.util.List;

@RequiredArgsConstructor
public class CastleFactory {

   public Castle createBaseCastle(){
       Castle castle = new Castle(null, "");
       CastleResource wood = new CastleResource(0L, 1000L,castle, CastleResource.ResourceType.WOOD);
       CastleResource clay = new CastleResource(0L, 1000L,castle, CastleResource.ResourceType.CLAY);
       CastleResource iron = new CastleResource(0L, 1000L,castle, CastleResource.ResourceType.IRON);
       CastleResource employee = new CastleResource(0L, 1000L,castle, CastleResource.ResourceType.EMPLOYEE);

       castle.addCastleResource(wood);
       castle.addCastleResource(clay);
       castle.addCastleResource(iron);
       castle.addCastleResource(employee);
       return castle;
   }
}
