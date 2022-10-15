package pl.dawid.main.castle.application.port.in;


import pl.dawid.main.aaShare.core.application.port.in.CreateUseCase;
import pl.dawid.main.castle.domain.Castle;

public interface CreateCastleUseCase extends CreateUseCase<Castle,CreateCastleCommand> {
}
