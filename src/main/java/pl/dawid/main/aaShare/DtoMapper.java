package pl.dawid.main.aaShare;

import java.util.List;

public interface DtoMapper<DOMAIN, DTO> {
    DTO map(DOMAIN source);

    List<DTO> map(List<DOMAIN> sourceList);
}
