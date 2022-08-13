package pl.dawid.main.castle.adapter.out.persistence;

import pl.dawid.main.castle.adapter.out.persistence.castle.CastleEntity;
import pl.dawid.main.castle.adapter.out.persistence.castle.CastleEntityMapper;
import pl.dawid.main.castle.adapter.out.persistence.castle.CastleEntityCommand;
import pl.dawid.main.castle.adapter.out.persistence.resource.CastleResourceEntityCommand;
import pl.dawid.main.castle.application.port.out.CreateCastlePort;
import pl.dawid.main.castle.application.port.out.LoadCastlePort;
import pl.dawid.main.castle.application.port.out.UpdateCastlePort;
import pl.dawid.main.castle.domain.Castle;

import java.util.List;

public class CastlePersistenceAdapter implements
        CreateCastlePort,
        LoadCastlePort,
        UpdateCastlePort {
    private final CastleEntityCommand castleEntityCommand;
    private final CastleResourceEntityCommand castleResourceEntityCommand;
    private final CastleEntityMapper castleEntityMapper = CastleEntityMapper.INSTANCE;

    public CastlePersistenceAdapter(CastleEntityCommand castleEntityCommand,
                                    CastleResourceEntityCommand castleResourceEntityCommand) {
        this.castleEntityCommand = castleEntityCommand;
        this.castleResourceEntityCommand = castleResourceEntityCommand;
    }

    @Override
    public Castle findById(Long id) {
        CastleEntity castleEntity = castleEntityCommand.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        return castleEntityMapper.mapToDomainObject(castleEntity);
    }

    @Override
    public List<Castle> findAll() {
        List<CastleEntity> castleEntityList = castleEntityCommand.findAll();
        return castleEntityMapper.mapToDomainObjectList(castleEntityList);
    }

    @Override
    public Castle createEntity(Castle castle) {
        if (castle.getId()!=null) {
            throw new IllegalStateException("Object cannot have an id");
        }
        CastleEntity castleEntity = castleEntityMapper.mapToJpaEntity(castle);
        CastleEntity castleEntitySaved = castleEntityCommand.saveAndFlush(castleEntity);
        return castleEntityMapper.mapToDomainObject(castleEntitySaved);
    }
}
