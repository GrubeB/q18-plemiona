package pl.dawid.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.dawid.main.castle.application.CreateCastleService;
import pl.dawid.main.castle.application.port.in.CreateCastleCommand;
import pl.dawid.main.config.database.Config;
import pl.dawid.main.controller.CastleControllerImpl;

@SpringBootApplication
public class Q14Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Q14Application.class, args);

		Config config = context.getBean(Config.class);
		config.init();

		CastleControllerImpl castleController = context.getBean(CastleControllerImpl.class);
		castleController.createNewCastle();

	}

}
