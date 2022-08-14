package pl.dawid.main.castle.application.port.in;


import pl.dawid.main.castle.domain.Castle;

public interface AddResourceToCastleUseCase {
    void addResourceToCastle(Long castleId, AddResourceToCastleCommand command);
}
