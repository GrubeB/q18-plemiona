package pl.dawid.main.castle.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import pl.dawid.main.castle.application.port.in.CreateCastleCommand;
import pl.dawid.main.castle.application.port.in.CreateCastleUseCase;
import pl.dawid.main.castle.application.port.out.CreateCastlePort;
import pl.dawid.main.castle.application.port.out.LoadCastlePort;
import pl.dawid.main.castle.application.port.out.UpdateCastlePort;


class CreateCastleServiceTest {

    private CreateCastlePort createCastlePort = Mockito.mock(CreateCastlePort.class);
    private LoadCastlePort loadCastlePort = Mockito.mock(LoadCastlePort.class);
    private UpdateCastlePort updateCastlePort = Mockito.mock(UpdateCastlePort.class);

    private CreateCastleService createCastleService = new CreateCastleService(createCastlePort);

    @Test
    void createCastle() {
        CreateCastleCommand command = new CreateCastleCommand("Nowa");
        createCastleService.createCastle(command);

    }
}