package edu.poly.shop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import edu.poly.shop.config.StorageProperties;
import edu.poly.shop.service.StorageService;

@EnableConfigurationProperties(StorageProperties.class)
@SpringBootApplication

public class Asmjava6Application extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(Asmjava6Application.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService service) {
		return (args -> {
			service.init();
		});
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("file:uploads/images/").setCachePeriod(0);
	}
}
