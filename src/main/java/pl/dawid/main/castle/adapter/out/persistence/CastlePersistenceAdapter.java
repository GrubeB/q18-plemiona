package pl.dawid.main.castle.adapter.out.persistence;

import org.mapstruct.factory.Mappers;
import pl.dawid.main.castle.adapter.out.persistence.castle.CastleEntity;
import pl.dawid.main.castle.adapter.out.persistence.castle.CastleEntityMapper;
import pl.dawid.main.castle.adapter.out.persistence.castle.CastleEntityCommand;
import pl.dawid.main.castle.adapter.out.persistence.resource.CastleResourceEntityCommand;
import pl.dawid.main.castle.application.port.out.CreateCastlePort;
import pl.dawid.main.castle.application.port.out.FetchCastlePort;
import pl.dawid.main.castle.application.port.out.UpdateCastlePort;
import pl.dawid.main.castle.domain.Castle;

import java.util.List;
import java.util.Optional;

public class CastlePersistenceAdapter implements
        CreateCastlePort,
        FetchCastlePort,
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
    public Optional<Castle> findById(Long id){
//        Optional<CastleEntity> castleEntity = castleEntityCommand.findById(id);
//        if(castleEntity.isPresent()){
//            return Optional.of(castleEntityMapper.mapToDomainObject(castleEntity.get()));
//        }
//        return Optional.empty();
        Optional<CastleEntity> castleEntity = castleEntityCommand.findById(id);
        return castleEntity.map(castleEntityMapper::mapToDomainObject);
    }

    @Override
    public List<Castle> findByName(String name) {
        List<CastleEntity> castleEntityList = castleEntityCommand.findByName(name);
        return castleEntityMapper.mapToDomainObjectList(castleEntityList);
    }

    @Override
    public List<Castle> findAll() {
        List<CastleEntity> castleEntityList = castleEntityCommand.findAll();
        return castleEntityMapper.mapToDomainObjectList(castleEntityList);
    }

    @Override
    public Castle createEntity(Castle castle) {
//        if (castle.getId()!=null) {
//            throw new IllegalStateException("Object cannot have an id");
//        }
        CastleEntity castleEntity = castleEntityMapper.mapToJpaEntity(castle);
        CastleEntity castleEntitySaved = castleEntityCommand.saveAndFlush(castleEntity);
        return castleEntityMapper.mapToDomainObject(castleEntitySaved);
    }
}
