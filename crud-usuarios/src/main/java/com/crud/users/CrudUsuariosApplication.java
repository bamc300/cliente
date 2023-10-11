package com.crud.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class CrudUsuariosApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(CrudUsuariosApplication.class, args);
	}

}
