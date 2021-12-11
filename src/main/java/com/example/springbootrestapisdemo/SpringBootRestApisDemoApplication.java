package com.example.springbootrestapisdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.*")
public class SpringBootRestApisDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApisDemoApplication.class, args);
	}

}
