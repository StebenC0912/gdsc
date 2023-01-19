package org.project.gdsc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"org.project.gdsc"})
public class GdscApplication {

	public static void main(String[] args) {
		SpringApplication.run(GdscApplication.class, args);
	}

}
