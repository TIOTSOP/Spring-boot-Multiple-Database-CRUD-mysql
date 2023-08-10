package com.deb.dynamicdatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.deb.dynamicdatasource.*")
public class DynamicDatasourceApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(DynamicDatasourceApplication.class, args);
	}

}