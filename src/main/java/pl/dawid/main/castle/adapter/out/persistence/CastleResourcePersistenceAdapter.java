package pl.dawid.main.castle.adapter.out.persistence;

import pl.dawid.main.castle.adapter.out.persistence.castle.CastleEntity;
import pl.dawid.main.castle.adapter.out.persistence.castle.CastleEntityCommand;
import pl.dawid.main.castle.adapter.out.persistence.castle.CastleEntityMapper;
import pl.dawid.main.castle.adapter.out.persistence.resource.CastleResourceEntity;
import pl.dawid.main.castle.adapter.out.persistence.resource.CastleResourceEntityCommand;
import pl.dawid.main.castle.adapter.out.persistence.resource.CastleResourceEntityMapper;
import pl.dawid.main.castle.application.port.out.CreateCastlePort;
import pl.dawid.main.castle.application.port.out.FetchCastlePort;
import pl.dawid.main.castle.application.port.out.FetchCastleResourcePort;
import pl.dawid.main.castle.application.port.out.UpdateCastlePort;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.castle.domain.CastleResource;

import java.util.List;
import java.util.Optional;

public class CastleResourcePersistenceAdapter implements
        FetchCastleResourcePort {
    private final CastleResourceEntityCommand castleResourceEntityCommand;
    private final CastleResourceEntityMapper castleResourceEntityMapper = CastleResourceEntityMapper.INSTANCE;

    public CastleResourcePersistenceAdapter(CastleResourceEntityCommand castleResourceEntityCommand) {
        this.castleResourceEntityCommand = castleResourceEntityCommand;
    }

    @Override
    public Optional<CastleResource> findById(Long id){
        Optional<CastleResourceEntity> castleResourceEntity = castleResourceEntityCommand.findById(id);
        return castleResourceEntity.map(castleResourceEntityMapper::mapToDomainObject);
    }

    @Override
    public List<CastleResource> findAll() {
        List<CastleResourceEntity> castleResourceEntityList = castleResourceEntityCommand.findAll();
        return castleResourceEntityMapper.mapToDomainObjectList(castleResourceEntityList);
    }

}
