package pl.dawid.main.castle.application.port.in;

import pl.dawid.main.castle.domain.Castle;

public interface FetchByIdUseCase {
    Castle fetchById(Long id);

}
