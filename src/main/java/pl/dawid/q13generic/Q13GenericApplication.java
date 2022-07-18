package pl.dawid.q13generic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.dawid.q13generic.entity.Test;
import pl.dawid.q13generic.repository.TestRepository;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Q13GenericApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Q13GenericApplication.class, args);
		TestRepository testRepository = context.getBean(TestRepository.class);
		List<Test> testList = Arrays.asList(
				Test.builder().title("Ala").description("12").build(),
				Test.builder().title("Zosia").description("32").build(),
				Test.builder().title("Ewa").description("32").build(),
				Test.builder().title("Kasia").description("42").build(),
				Test.builder().title("Madzia").description("12").build(),
				Test.builder().title("Ola").description("41").build(),
				Test.builder().title("Ila").description("31").build(),
				Test.builder().title("Maja").description("322").build(),
				Test.builder().title("Aga").description("323").build(),
				Test.builder().title("Tadek").description("232").build()
		);
		testRepository.saveAll(testList);
	}

}
