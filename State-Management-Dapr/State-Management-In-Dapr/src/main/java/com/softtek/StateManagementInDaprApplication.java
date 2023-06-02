package com.softtek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//dapr run --app-id StateManagement --app-port 3500 -- java -jar target/State-Management-In-Dapr-0.0.1-SNAPSHOT.jar
@SpringBootApplication
public class StateManagementInDaprApplication {

	public static void main(String[] args) {
		SpringApplication.run(StateManagementInDaprApplication.class, args);
	}

}
