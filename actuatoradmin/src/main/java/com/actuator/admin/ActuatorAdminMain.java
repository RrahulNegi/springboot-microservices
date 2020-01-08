package com.actuator.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import de.codecentric.boot.admin.server.config.EnableAdminServer;


@EnableAdminServer
@SpringBootApplication
public class ActuatorAdminMain {

	public static void main(String[] args) {
		SpringApplication.run(ActuatorAdminMain.class, args);

	}

}
