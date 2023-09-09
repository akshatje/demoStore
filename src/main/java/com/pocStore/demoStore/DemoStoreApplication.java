package com.pocStore.demoStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class DemoStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoStoreApplication.class, args);
	}

}
