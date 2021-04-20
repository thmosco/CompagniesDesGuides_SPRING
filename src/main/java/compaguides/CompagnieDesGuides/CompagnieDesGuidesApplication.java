package compaguides.CompagnieDesGuides;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages= {"com.vz.spring.items", "controller"})
@ComponentScan(basePackages={"c.CompagnieDesGuides"})
public class CompagnieDesGuidesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompagnieDesGuidesApplication.class, args);
	}

}
