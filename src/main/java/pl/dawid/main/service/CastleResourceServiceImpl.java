package pl.dawid.main.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import pl.dawid.main.dto.castleResource.CastleResourceFlatDto;
import pl.dawid.main.entity.castle.Castle;
import pl.dawid.main.mapper.CastleResourceMapper;
import pl.dawid.main.repository.CastleResourceRepository;

import java.util.List;

//@Service
@Getter
@AllArgsConstructor
public class CastleResourceServiceImpl implements CastleResourceService {
    private CastleResourceRepository repository;
    private CastleResourceMapper mapper;
    private CastleResourceMapper createMapper;
    private CastleResourceMapper updateMapper;

    private CastleService castleService;

    public List<CastleResourceFlatDto> fetchCastleResourcesByCastleId(Long castleId) {
        Castle castle = castleService.fetchEntityById(castleId);
        return getMapper().mapEntityListToFlatListDto(castle.getCastleResourceList());
    }

    public List<CastleResourceFlatDto> addCastleResourcesByCastleId(Long castleId, List<CastleResourceFlatDto> castleResourceFlatDtoList) {
        Castle castle = castleService.fetchEntityById(castleId);
        castle.getCastleResourceList().forEach((castleResource) -> {
                    castleResource.addAmount(
                            castleResourceFlatDtoList.stream()
                                    .filter((dto) -> dto.getTitle().equals(castleResource.getResource().getTitle()))
                                    .map(CastleResourceFlatDto::getAmount)
                                    .findAny().orElse(0L)
                    );
                }
        );
        castleService.updateEntity(castle.getId(),castle);
        return getMapper().mapEntityListToFlatListDto(castle.getCastleResourceList());
    }
}
