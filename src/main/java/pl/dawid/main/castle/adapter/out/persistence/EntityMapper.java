package pl.dawid.main.castle.adapter.out.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.castle.domain.DomainId;
import pl.dawid.main.mapper.root.GMapper;

import java.util.List;
import java.util.Set;

public interface EntityMapper<JPA_ENTITY, DOMAIN_OBJECT> {

    DOMAIN_OBJECT mapToDomainObject(JPA_ENTITY source);

    JPA_ENTITY mapToJpaEntity(DOMAIN_OBJECT source);

    Set<DOMAIN_OBJECT> mapToDomainObjectSet(Set<JPA_ENTITY> source);

    Set<JPA_ENTITY> mapToJpaEntitySet(Set<DOMAIN_OBJECT> source);

    List<DOMAIN_OBJECT> mapToDomainObjectList(List<JPA_ENTITY> source);

    List<JPA_ENTITY> mapToJpaEntityList(List<DOMAIN_OBJECT> source);
}
