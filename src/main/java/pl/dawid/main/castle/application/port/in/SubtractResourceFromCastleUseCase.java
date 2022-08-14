package pl.dawid.main.castle.application.port.in;


public interface SubtractResourceFromCastleUseCase {
    void subtractResourceFromCastle(Long castleId, SubtractResourceFromCastleCommand command);
}
