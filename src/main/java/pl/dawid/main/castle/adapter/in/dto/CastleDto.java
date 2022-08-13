package pl.dawid.main.castle.adapter.in.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CastleDto {
    private Long id;
    private String name;
    private List<CastleResourceDto> castleResourceList;
}
