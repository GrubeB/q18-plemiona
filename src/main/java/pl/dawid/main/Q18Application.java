package pl.dawid.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Q18Application {

    private static final Logger logger = LoggerFactory.getLogger(Q18Application.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(Q18Application.class, args);
    }

}
