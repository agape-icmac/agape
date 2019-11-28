package br.com.agape.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**")
				.allowedOrigins(
						"http://localhost:63342",
						"http://localhost:63343",
						"http://localhost:63345",
						"https://agape-backend.herokuapp.com",
						"https://agape-icmac.github.io")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
				.allowedHeaders("*")
				.allowCredentials(true);
	}

}
