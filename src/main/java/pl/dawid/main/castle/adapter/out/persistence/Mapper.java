package pl.dawid.main.castle.adapter.out.persistence;

import pl.dawid.main.castle.adapter.out.persistence.castle.CastleEntity;
import pl.dawid.main.castle.adapter.out.persistence.resource.CastleResourceEntity;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.castle.domain.CastleResource;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

//    Castle mapCastleToDomainObject(CastleEntity source){
//        if ( source == null ) {
//            return null;
//        }
//        Castle castle = new Castle();
//        castle.setId( source.getId() );
//        castle.setName( source.getName() );
//
//        for ( CastleResourceEntity castleResourceList : source.getCastleResourceList() ) {
//            CastleResource castleResource = mapCastleResourceToDomainObject(castleResourceList);
//            castle.addCastleResource(castleResource);
//            castleResource.setCastle(castle); //===========================================================
//        }
//        return castle;
//    }
//    CastleResource mapCastleResourceToDomainObject(CastleResourceEntity source){
//        if ( source == null ) {
//            return null;
//        }
//        CastleResource castleResource = new CastleResource();
//        castleResource.setId( source.getId() );
//        castleResource.setAmount( source.getAmount() );
//        castleResource.setAmountMax( source.getAmountMax() );
//        castleResource.setType( source.getType() );
//        return castleResource;
//    }
//
//    public CastleEntity mapCastleToJpaEntity(Castle source){
//        if ( source == null ) {
//            return null;
//        }
//
//        CastleEntity castleEntity = new CastleEntity();
//            castleEntity.setId( source.getId() );
//            castleEntity.setName( source.getName() );
//        List<CastleResourceEntity> list
//                =  source.getCastleResourceList().stream()
//                .map(this::mapCastleResourceToJpaEntity)
//                .collect(Collectors.toList());
//        list.forEach(s->s.setCastle(castleEntity)); //===========================================================
//        castleEntity.setCastleResourceList( list );
//        return castleEntity;
//    }
//    public CastleResourceEntity mapCastleResourceToJpaEntity(CastleResource source) {
//        if ( source == null ) {
//            return null;
//        }
//        CastleResourceEntity castleResourceEntity = new CastleResourceEntity();
//
//        castleResourceEntity.setId( source.getId() );
//        castleResourceEntity.setAmount( source.getAmount() );
//        castleResourceEntity.setAmountMax( source.getAmountMax() );
//        castleResourceEntity.setType( source.getType() );
//        return castleResourceEntity;
//    }
}
