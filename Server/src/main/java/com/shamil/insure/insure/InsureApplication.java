package com.shamil.insure.insure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class InsureApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsureApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer coresConfigure() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("POST", "GET", "OPTIONS", "PUT", "DELETE");
			}
		};
	}

}
