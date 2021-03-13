package com.qbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2 //http://localhost:9940/swagger-ui.html -- http://localhost:9940/v2/api-docs
public class ApiSbQboSwaggerCorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSbQboSwaggerCorsApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
				.addMapping("/api/v1/cliente/**")
				.allowedMethods("GET", "POST", "PUT", "DELETE")
				.allowedOrigins("*");
				//.allowedOrigins("http://localhost:8080");
			}
		};
	}
}
