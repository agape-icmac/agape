package br.com.agape.agapeApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "br.com.agape.model")
@ComponentScan(basePackages = "br.com.agape.controller")
@ComponentScan(basePackages = "br.com.agape.config")
@EnableJpaRepositories(basePackages = "br.com.agape.repository")
public class AgapeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgapeApplication.class, args);
	}

}
