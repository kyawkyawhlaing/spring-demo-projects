package org.kyawhlaing.apachepoi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApachepoiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApachepoiApplication.class, args);
	}

}
